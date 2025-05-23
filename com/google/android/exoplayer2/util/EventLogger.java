package com.google.android.exoplayer2.util;

import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.metadata.scte35.SpliceCommand;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.util.WiFiDash;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EventLogger implements Player.EventListener, MetadataOutput, AudioRendererEventListener, VideoRendererEventListener, MediaSourceEventListener, AdsMediaSource.EventListener, DefaultDrmSessionManager.EventListener {
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final String TAG = "EventLogger";
    private static final NumberFormat TIME_FORMAT;
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window = new Timeline.Window();
    private final Timeline.Period period = new Timeline.Period();
    private final long startTimeMs = android.os.SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this.trackSelector = mappingTrackSelector;
    }

    private static String getAdaptiveSupportString(int i3, int i16) {
        if (i3 < 2) {
            return WiFiDash.NOT_AVALIBLE;
        }
        if (i16 != 0) {
            if (i16 != 8) {
                if (i16 != 16) {
                    return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                return "YES";
            }
            return "YES_NOT_SEAMLESS";
        }
        return "NO";
    }

    private static String getDiscontinuityReasonString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                        }
                        return "INTERNAL";
                    }
                    return "AD_INSERTION";
                }
                return "SEEK_ADJUSTMENT";
            }
            return "SEEK";
        }
        return "PERIOD_TRANSITION";
    }

    private static String getFormatSupportString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                        }
                        return "YES";
                    }
                    return "NO_EXCEEDS_CAPABILITIES";
                }
                return "NO_UNSUPPORTED_DRM";
            }
            return "NO_UNSUPPORTED_TYPE";
        }
        return "NO";
    }

    private static String getRepeatModeString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                return "ALL";
            }
            return "ONE";
        }
        return "OFF";
    }

    private String getSessionTimeString() {
        return getTimeString(android.os.SystemClock.elapsedRealtime() - this.startTimeMs);
    }

    private static String getStateString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                    }
                    return "E";
                }
                return BdhLogUtil.LogTag.Tag_Req;
            }
            return "B";
        }
        return "I";
    }

    private static String getTimeString(long j3) {
        if (j3 == -9223372036854775807L) {
            return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        return TIME_FORMAT.format(((float) j3) / 1000.0f);
    }

    private static String getTimelineChangeReasonString(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                return "DYNAMIC";
            }
            return "RESET";
        }
        return "PREPARED";
    }

    private static String getTrackStatusString(boolean z16) {
        return z16 ? "[X]" : "[ ]";
    }

    private void printInternalError(String str, Exception exc) {
        Log.e(TAG, "internalError [" + getSessionTimeString() + ", " + str + "]", exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i3 = 0; i3 < metadata.length(); i3++) {
            Metadata.Entry entry = metadata.get(i3);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                Log.d(TAG, str + String.format("%s: value=%s", textInformationFrame.f32945id, textInformationFrame.value));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                Log.d(TAG, str + String.format("%s: url=%s", urlLinkFrame.f32945id, urlLinkFrame.url));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                Log.d(TAG, str + String.format("%s: owner=%s", privFrame.f32945id, privFrame.owner));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                Log.d(TAG, str + String.format("%s: mimeType=%s, filename=%s, description=%s", geobFrame.f32945id, geobFrame.mimeType, geobFrame.filename, geobFrame.description));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                Log.d(TAG, str + String.format("%s: mimeType=%s, description=%s", apicFrame.f32945id, apicFrame.mimeType, apicFrame.description));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                Log.d(TAG, str + String.format("%s: language=%s, description=%s", commentFrame.f32945id, commentFrame.language, commentFrame.description));
            } else if (entry instanceof Id3Frame) {
                Log.d(TAG, str + String.format("%s", ((Id3Frame) entry).f32945id));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                Log.d(TAG, str + String.format("EMSG: scheme=%s, id=%d, value=%s", eventMessage.schemeIdUri, Long.valueOf(eventMessage.f32944id), eventMessage.value));
            } else if (entry instanceof SpliceCommand) {
                Log.d(TAG, str + String.format("SCTE-35 splice command: type=%s.", entry.getClass().getSimpleName()));
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public boolean isNeedAudioData() {
        return false;
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.EventListener
    public void onAdLoadError(IOException iOException) {
        printInternalError("adLoadError", iOException);
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDecoderInitialized(String str, long j3, long j16) {
        Log.d(TAG, "audioDecoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioDisabled(DecoderCounters decoderCounters) {
        Log.d(TAG, "audioDisabled [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioEnabled(DecoderCounters decoderCounters) {
        Log.d(TAG, "audioEnabled [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioInputFormatChanged(Format format) {
        Log.d(TAG, "audioFormatChanged [" + getSessionTimeString() + ", " + Format.toLogString(format) + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioSessionId(int i3) {
        Log.d(TAG, "audioSessionId [" + i3 + "]");
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onAudioSinkUnderrun(int i3, long j3, long j16) {
        printInternalError("audioTrackUnderrun [" + i3 + ", " + j3 + ", " + j16 + "]", null);
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmKeysLoaded() {
        Log.d(TAG, "drmKeysLoaded [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmKeysRemoved() {
        Log.d(TAG, "drmKeysRemoved [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmKeysRestored() {
        Log.d(TAG, "drmKeysRestored [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSessionManager.EventListener
    public void onDrmSessionManagerError(Exception exc) {
        printInternalError("drmSessionManagerError", exc);
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onDroppedFrames(int i3, long j3) {
        Log.d(TAG, "droppedFrames [" + getSessionTimeString() + ", " + i3 + "]");
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.EventListener
    public void onInternalAdLoadError(RuntimeException runtimeException) {
        printInternalError("internalAdLoadError", runtimeException);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadError(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19, IOException iOException, boolean z16) {
        printInternalError("loadError", iOException);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z16) {
        Log.d(TAG, "loading [" + z16 + "]");
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public void onMetadata(Metadata metadata) {
        Log.d(TAG, "onMetadata [");
        printMetadata(metadata, "  ");
        Log.d(TAG, "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Log.d(TAG, "playbackParameters " + String.format("[speed=%.2f, pitch=%.2f]", Float.valueOf(playbackParameters.speed), Float.valueOf(playbackParameters.pitch)));
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Log.e(TAG, "playerFailed [" + getSessionTimeString() + "]", exoPlaybackException);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z16, int i3) {
        Log.d(TAG, "state [" + getSessionTimeString() + ", " + z16 + ", " + getStateString(i3) + "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i3) {
        Log.d(TAG, "positionDiscontinuity [" + getDiscontinuityReasonString(i3) + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onRenderedFirstFrame(Surface surface) {
        Log.d(TAG, "renderedFirstFrame [" + surface + "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i3) {
        Log.d(TAG, "repeatMode [" + getRepeatModeString(i3) + "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
        Log.d(TAG, "seekProcessed");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z16) {
        Log.d(TAG, "shuffleModeEnabled [" + z16 + "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object obj, int i3) {
        int periodCount = timeline.getPeriodCount();
        int windowCount = timeline.getWindowCount();
        Log.d(TAG, "timelineChanged [periodCount=" + periodCount + ", windowCount=" + windowCount + ", reason=" + getTimelineChangeReasonString(i3));
        for (int i16 = 0; i16 < Math.min(periodCount, 3); i16++) {
            timeline.getPeriod(i16, this.period);
            Log.d(TAG, "  period [" + getTimeString(this.period.getDurationMs()) + "]");
        }
        if (periodCount > 3) {
            Log.d(TAG, "  ...");
        }
        for (int i17 = 0; i17 < Math.min(windowCount, 3); i17++) {
            timeline.getWindow(i17, this.window);
            Log.d(TAG, "  window [" + getTimeString(this.window.getDurationMs()) + ", " + this.window.isSeekable + ", " + this.window.isDynamic + "]");
        }
        if (windowCount > 3) {
            Log.d(TAG, "  ...");
        }
        Log.d(TAG, "]");
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        EventLogger eventLogger;
        EventLogger eventLogger2 = this;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = eventLogger2.trackSelector.getCurrentMappedTrackInfo();
        if (currentMappedTrackInfo == null) {
            Log.d(TAG, "Tracks []");
            return;
        }
        Log.d(TAG, "Tracks [");
        int i3 = 0;
        while (true) {
            String str = "  ]";
            String str2 = " [";
            if (i3 >= currentMappedTrackInfo.length) {
                break;
            }
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i3);
            TrackSelection trackSelection = trackSelectionArray.get(i3);
            if (trackGroups.length > 0) {
                Log.d(TAG, "  Renderer:" + i3 + " [");
                int i16 = 0;
                while (i16 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i16);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String str3 = str;
                    Log.d(TAG, "    Group:" + i16 + ", adaptive_supported=" + getAdaptiveSupportString(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i3, i16, false)) + str2);
                    int i17 = 0;
                    while (i17 < trackGroup.length) {
                        Log.d(TAG, "      " + getTrackStatusString(trackSelection, trackGroup, i17) + " Track:" + i17 + ", " + Format.toLogString(trackGroup.getFormat(i17)) + ", supported=" + getFormatSupportString(currentMappedTrackInfo.getTrackFormatSupport(i3, i16, i17)));
                        i17++;
                        str2 = str2;
                    }
                    Log.d(TAG, "    ]");
                    i16++;
                    trackGroups = trackGroupArray2;
                    str = str3;
                }
                String str4 = str;
                if (trackSelection != null) {
                    for (int i18 = 0; i18 < trackSelection.length(); i18++) {
                        Metadata metadata = trackSelection.getFormat(i18).metadata;
                        if (metadata != null) {
                            Log.d(TAG, "    Metadata [");
                            eventLogger = this;
                            eventLogger.printMetadata(metadata, "      ");
                            Log.d(TAG, "    ]");
                            break;
                        }
                    }
                }
                eventLogger = this;
                Log.d(TAG, str4);
            } else {
                eventLogger = eventLogger2;
            }
            i3++;
            eventLogger2 = eventLogger;
        }
        String str5 = " [";
        TrackGroupArray unassociatedTrackGroups = currentMappedTrackInfo.getUnassociatedTrackGroups();
        if (unassociatedTrackGroups.length > 0) {
            Log.d(TAG, "  Renderer:None [");
            int i19 = 0;
            while (i19 < unassociatedTrackGroups.length) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("    Group:");
                sb5.append(i19);
                String str6 = str5;
                sb5.append(str6);
                Log.d(TAG, sb5.toString());
                TrackGroup trackGroup2 = unassociatedTrackGroups.get(i19);
                int i26 = 0;
                while (i26 < trackGroup2.length) {
                    TrackGroupArray trackGroupArray3 = unassociatedTrackGroups;
                    Log.d(TAG, "      " + getTrackStatusString(false) + " Track:" + i26 + ", " + Format.toLogString(trackGroup2.getFormat(i26)) + ", supported=" + getFormatSupportString(0));
                    i26++;
                    unassociatedTrackGroups = trackGroupArray3;
                }
                Log.d(TAG, "    ]");
                i19++;
                str5 = str6;
            }
            Log.d(TAG, "  ]");
        }
        Log.d(TAG, "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDecoderInitialized(String str, long j3, long j16) {
        Log.d(TAG, "videoDecoderInitialized [" + getSessionTimeString() + ", " + str + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoDisabled(DecoderCounters decoderCounters) {
        Log.d(TAG, "videoDisabled [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoEnabled(DecoderCounters decoderCounters) {
        Log.d(TAG, "videoEnabled [" + getSessionTimeString() + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoInputFormatChanged(Format format) {
        Log.d(TAG, "videoFormatChanged [" + getSessionTimeString() + ", " + Format.toLogString(format) + "]");
    }

    @Override // com.google.android.exoplayer2.video.VideoRendererEventListener
    public void onVideoSizeChanged(int i3, int i16, int i17, float f16) {
        Log.d(TAG, "videoSizeChanged [" + i3 + ", " + i16 + "]");
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i3) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i3) == -1) ? false : true);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.EventListener
    public void onAdClicked() {
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsMediaSource.EventListener
    public void onAdTapped() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public void onRenderAudioData(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCanceled(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadCompleted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17, long j18, long j19) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onUpstreamDiscarded(int i3, long j3, long j16) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onLoadStarted(DataSpec dataSpec, int i3, int i16, Format format, int i17, Object obj, long j3, long j16, long j17) {
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public void onDownstreamFormatChanged(int i3, Format format, int i16, Object obj, long j3) {
    }
}
