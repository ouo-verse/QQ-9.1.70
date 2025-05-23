package com.tencent.gamematrix.gmcg.webrtc;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.medialab.video.decoder.VDecoder;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.io.FileUtils;
import org.tencwebrtc.RendererCommon;
import org.tencwebrtc.SurfaceViewRenderer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class DecodeCapsDetector {
    private static final String DETECT_DATA_HYPERLINKS = "https://gamer.qpic.cn/activity/detectVideoV1.0.zip";
    private static Surface displaySurface;
    private static boolean isDownloading;
    private static int sDetectTimes;
    private double mBestAvgDecodeFramerate;
    private double mBestAvgDecodeTime;
    private String mBestCodec;
    private DecoderConfig mBestDecoderConfig;
    private int mBestFrameRate;
    private VideoResulotion mBestResolution;
    private String mBestView;
    private Context mCtx;
    private VDecoder.DecAbility[] mDecAbility;
    private DecodeCapsCallback mDecCapsCb;
    private Handler mHandler;
    private boolean mIsDetect720p30fpsOnly;
    private int mScreenHeight;
    private int mScreenWidth;
    private StreamsInfo[] mStreamInfDataset;
    private Surface mSurfaceDisplay;
    private SurfaceViewRenderer mSurfaceView;
    private Surface mTextureDisplay;
    private TextureViewRenderer mTextureView;
    private VDecoder mVdecoder;
    private int mVdecoderLogLevel;
    public final VideoResulotion V720P = new VideoResulotion(1280, 720);
    public final VideoResulotion V1080P = new VideoResulotion(1920, 1080);
    private final String TAG = "DecodeCapsDetector";
    private String mTunnelStatus = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    private String[] mStreamNames = {"H264_720p@60fps.264", "H264_1080p@60fps.264", "H265_720p@60fps.265", "H265_1080p@60fps.265"};
    VDecoder.DecStatistics mStats = new VDecoder.DecStatistics();
    private final int mApiLevel = Build.VERSION.SDK_INT;
    private final int MAX_STREAMS = 4;
    private final int MAX_SURFACE_COUNT = 30;
    private ArrayList<DecoderConfig> mDecoderConfigArray = new ArrayList<>();
    private final String SURFACE_VIEW = "SurfaceView";
    private final String TEXTURE_VIEW = "TextureView";
    private final int MSG_WHAT_SURFACE_VIEW = 1;
    private final int MSG_WHAT_TEXTURE_VIEW = 2;
    private final int MAX_DOWNLOAD_TIME = 3000;
    private int[] mCodecTypes = {16, 17};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public enum CODEC_TYPES {
        CODE_TYPE_H264,
        CODE_TYPE_H265,
        CODE_TYEP_MAX
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface DecodeCapsCallback {
        void onDecodeCapsReported(int i3, int i16, String str, String str2, int i17, String str3, int i18, double d16, double d17);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class DecoderConfig {
        public int mCodecType;
        public VDecoder.DecStatistics mDecStats;
        public int mFrameRate;
        public VideoResulotion mVideoResolution;
        public String mViewType;

        public DecoderConfig(int i3, String str, int i16, VideoResulotion videoResulotion, VDecoder.DecStatistics decStatistics) {
            this.mCodecType = i3;
            this.mViewType = str;
            this.mFrameRate = i16;
            this.mVideoResolution = videoResulotion;
            this.mDecStats = decStatistics;
        }

        public boolean compareTo(DecoderConfig decoderConfig) {
            if (this.mFrameRate == decoderConfig.mFrameRate && Math.abs(this.mDecStats.f151564l - decoderConfig.mDecStats.f151564l) >= 2.0d) {
                if (this.mDecStats.f151564l > decoderConfig.mDecStats.f151564l) {
                    return true;
                }
                return false;
            }
            VDecoder.DecStatistics decStatistics = this.mDecStats;
            int i3 = decStatistics.f151553a;
            VDecoder.DecStatistics decStatistics2 = decoderConfig.mDecStats;
            if (i3 == decStatistics2.f151553a) {
                if (decStatistics.f151560h < decStatistics2.f151560h) {
                    return true;
                }
                return false;
            }
            if (i3 == 17) {
                double d16 = decStatistics.f151560h;
                if (d16 < 10.0d) {
                    return true;
                }
                double d17 = decStatistics2.f151560h;
                if (d16 < d17) {
                    return true;
                }
                int i16 = (int) (d16 / 16.0d);
                int i17 = (int) (d17 / 16.0d);
                if (i16 == i17) {
                    if (d16 < d17 + 5.0d) {
                        return true;
                    }
                    return false;
                }
                if (i16 < i17) {
                    return true;
                }
                return false;
            }
            double d18 = decStatistics2.f151560h;
            if (d18 >= 10.0d) {
                double d19 = decStatistics.f151560h;
                if (d19 <= d18) {
                    int i18 = (int) (d19 / 16.0d);
                    int i19 = (int) (d18 / 16.0d);
                    if (i18 == i19) {
                        if (d19 < d18 - 5.0d) {
                            return true;
                        }
                        return false;
                    }
                    if (i18 < i19) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public boolean compareToWithDecodeTime(DecoderConfig decoderConfig) {
            if (this.mDecStats.f151560h < decoderConfig.mDecStats.f151560h) {
                return true;
            }
            return false;
        }

        public boolean compareToWithFPS(DecoderConfig decoderConfig) {
            if (this.mDecStats.f151564l > decoderConfig.mDecStats.f151564l) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class StreamsInfo {
        public byte[] data = null;
        public boolean isDownloaded = false;
        public boolean isLoaded = false;

        public StreamsInfo() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class VideoResulotion {
        public int mHeight;
        public int mWidth;

        public VideoResulotion(int i3, int i16) {
            this.mWidth = i3;
            this.mHeight = i16;
        }

        public boolean isEqual(VideoResulotion videoResulotion) {
            if (this.mWidth == videoResulotion.mWidth && this.mHeight == videoResulotion.mHeight) {
                return true;
            }
            return false;
        }
    }

    public DecodeCapsDetector(Context context, SurfaceViewRenderer surfaceViewRenderer, TextureViewRenderer textureViewRenderer, int i3) {
        this.mVdecoderLogLevel = 4;
        this.mCtx = context;
        this.mSurfaceView = surfaceViewRenderer;
        surfaceViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
        this.mSurfaceView.setEnableHardwareScaler(true);
        this.mSurfaceView.setZOrderMediaOverlay(true);
        this.mTextureView = textureViewRenderer;
        sDetectTimes = 0;
        this.mStreamInfDataset = new StreamsInfo[4];
        int i16 = 0;
        while (true) {
            StreamsInfo[] streamsInfoArr = this.mStreamInfDataset;
            if (i16 < streamsInfoArr.length) {
                streamsInfoArr[i16] = new StreamsInfo();
                i16++;
            } else {
                loadDetectDataIfExist();
                VDecoder.DecAbility[] decAbilityArr = new VDecoder.DecAbility[CODEC_TYPES.CODE_TYEP_MAX.ordinal()];
                this.mDecAbility = decAbilityArr;
                decAbilityArr[0] = new VDecoder.DecAbility();
                this.mDecAbility[1] = new VDecoder.DecAbility();
                this.mVdecoderLogLevel = i3;
                this.mIsDetect720p30fpsOnly = false;
                this.mHandler = new Handler() { // from class: com.tencent.gamematrix.gmcg.webrtc.DecodeCapsDetector.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        int i17 = message.what;
                        if (i17 != 1) {
                            if (i17 == 2 && DecodeCapsDetector.this.mTextureView != null) {
                                DecodeCapsDetector.this.mTextureView.setVisibility(0);
                                if (DecodeCapsDetector.this.mSurfaceView != null) {
                                    DecodeCapsDetector.this.mSurfaceView.setVisibility(4);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (DecodeCapsDetector.this.mSurfaceView != null) {
                            DecodeCapsDetector.this.mSurfaceView.setVisibility(0);
                            if (DecodeCapsDetector.this.mTextureView != null) {
                                DecodeCapsDetector.this.mTextureView.setVisibility(4);
                            }
                        }
                    }
                };
                return;
            }
        }
    }

    private void detectDecode720p30fpsH264Only() {
        CGLog.i("detectDecode720p30fpsH264Only");
        int size = this.mDecoderConfigArray.size();
        detectDecodeCapsModule(16, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 28.0d && decStatistics.f151560h < 50.0d) {
            this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 0);
            return;
        }
        detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics2 = this.mStats;
        if (decStatistics2.f151564l >= 28.0d && decStatistics2.f151560h < 50.0d) {
            this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 1);
        } else {
            this.mBestDecoderConfig = selectBestConfig();
        }
    }

    private void detectDecode720p30fpsH265Preferred() {
        CGLog.i("detectDecode720p30fpsH265Preferred");
        detectDecodeCapsModule(17, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 28.0d) {
            double d16 = decStatistics.f151560h;
            if (d16 < 50.0d) {
                if (d16 < 20.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                    return;
                }
                detectDecodeCapsModule(16, "SurfaceView", 30, this.V720P);
                if (d16 < this.mStats.f151560h) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                }
            }
            detectDecodeCapsModule(17, "TextureView", 30, this.V720P);
            VDecoder.DecStatistics decStatistics2 = this.mStats;
            if (decStatistics2.f151564l >= 28.0d) {
                double d17 = decStatistics2.f151560h;
                if (d17 < 50.0d) {
                    if (d17 < 20.0d) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                        return;
                    }
                    detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
                    if (d17 < this.mStats.f151560h) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                        return;
                    } else {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                        return;
                    }
                }
            }
            detectDecodeH265ToH264Only720p30fps(true);
            return;
        }
        detectDecodeH265ToH264Only720p30fps(false);
    }

    private boolean detectDecode720pH264Only() {
        CGLog.i("detectDecode720pH264Only");
        int size = this.mDecoderConfigArray.size();
        detectDecodeCapsModule(16, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 28.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "SurfaceView", 60, this.V720P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                if (decStatistics2.f151560h < 50.0d && decStatistics2.f151564l >= 55.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 1);
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 0);
                }
                return true;
            }
            detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 28.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                if (decStatistics4.f151560h < 50.0d && decStatistics4.f151564l >= 55.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 2);
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 1);
                }
                return true;
            }
            this.mBestDecoderConfig = selectBestConfig();
            return false;
        }
        detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics5 = this.mStats;
        if (decStatistics5.f151564l >= 28.0d && decStatistics5.f151560h < 50.0d) {
            detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
            VDecoder.DecStatistics decStatistics6 = this.mStats;
            if (decStatistics6.f151560h < 50.0d && decStatistics6.f151564l >= 55.0d) {
                this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 2);
            } else {
                this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 1);
            }
            return true;
        }
        this.mBestDecoderConfig = selectBestConfig();
        return false;
    }

    private boolean detectDecode720pH265Preferred() {
        CGLog.i("detectDecode720pH265Preferred");
        detectDecodeCapsModule(17, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 28.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(17, "SurfaceView", 60, this.V720P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                double d16 = decStatistics2.f151560h;
                if (d16 < 50.0d && decStatistics2.f151564l >= 55.0d) {
                    if (d16 < 20.0d) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    } else {
                        detectDecodeCapsModule(16, "SurfaceView", 60, this.V720P);
                        if (d16 < this.mStats.f151560h) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                        } else {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                        }
                    }
                } else {
                    double d17 = this.mDecoderConfigArray.get(0).mDecStats.f151560h;
                    if (d17 < 20.0d) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                    } else {
                        detectDecodeCapsModule(16, "SurfaceView", 30, this.V720P);
                        if (d17 < this.mStats.f151560h) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                        } else {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                        }
                    }
                }
                return true;
            }
            detectDecodeCapsModule(17, "TextureView", 30, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 28.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(17, "TextureView", 60, this.V720P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                double d18 = decStatistics4.f151560h;
                if (d18 < 50.0d && decStatistics4.f151564l >= 55.0d) {
                    if (d18 < 20.0d) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    } else {
                        detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
                        if (d18 < this.mStats.f151560h) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                        } else {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                        }
                    }
                } else {
                    double d19 = this.mDecoderConfigArray.get(1).mDecStats.f151560h;
                    if (d19 < 20.0d) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    } else {
                        detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
                        if (d19 < this.mStats.f151560h) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                        } else {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                        }
                    }
                }
                return true;
            }
            return detectDecode720pH264Only();
        }
        return detectDecode720pH264Only();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectDecodeCaps720p30fpsOnly() {
        if (this.mDecAbility[CODEC_TYPES.CODE_TYPE_H265.ordinal()].f151528b != 0) {
            detectDecode720p30fpsH265Preferred();
        } else {
            detectDecode720p30fpsH264Only();
        }
        setBestConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectDecodeCapsGe1080() {
        VDecoder.DecAbility[] decAbilityArr = this.mDecAbility;
        CODEC_TYPES codec_types = CODEC_TYPES.CODE_TYPE_H265;
        if (decAbilityArr[codec_types.ordinal()].f151528b != 0) {
            if (this.mDecAbility[codec_types.ordinal()].f151530d >= 1080 && this.mApiLevel > 23) {
                detectDecodePreferH265();
            } else {
                detectDecodePreferH264();
            }
        } else {
            detectDecodeH264Only();
        }
        setBestConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectDecodeCapsLt1080() {
        if (this.mDecAbility[CODEC_TYPES.CODE_TYPE_H265.ordinal()].f151528b != 0) {
            detectDecode720pH265Preferred();
        } else {
            detectDecode720pH264Only();
        }
        setBestConfig();
    }

    private int detectDecodeCapsModule(int i3, String str, int i16, VideoResulotion videoResulotion) {
        boolean z16;
        int i17;
        boolean z17 = true;
        sDetectTimes++;
        byte[] specificStreamData = getSpecificStreamData(i3, i16, videoResulotion);
        displaySurface = getDisplaySurface(str);
        VDecoder.DecStatistics decStatistics = new VDecoder.DecStatistics();
        if (specificStreamData != null && displaySurface != null) {
            VDecoder vDecoder = new VDecoder(this.mVdecoderLogLevel, true);
            this.mVdecoder = vDecoder;
            vDecoder.h(i3, displaySurface, i16, videoResulotion.mWidth, videoResulotion.mHeight);
            int a16 = this.mVdecoder.a(specificStreamData, decStatistics);
            this.mVdecoder.l();
            if (a16 != 0) {
                decStatistics.f151560h = 10000.0d;
                decStatistics.f151564l = 0.0d;
                CGLog.i("DecodeCapsDetector decode stream failed, ret: " + a16);
            }
            i17 = a16;
        } else {
            decStatistics.f151560h = 10000.0d;
            decStatistics.f151564l = 0.0d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("DecodeCapsDetector fail to detectDecodeCapsModule: dataSet is null:");
            if (specificStreamData == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(" displaySurface is null: ");
            if (displaySurface != null) {
                z17 = false;
            }
            sb5.append(z17);
            CGLog.i(sb5.toString());
            i17 = 0;
        }
        DecoderConfig decoderConfig = new DecoderConfig(i3, str, i16, videoResulotion, decStatistics);
        this.mStats = decStatistics;
        this.mDecoderConfigArray.add(decoderConfig);
        for (int i18 = 0; i18 < this.mDecoderConfigArray.size(); i18++) {
            DecoderConfig decoderConfig2 = this.mDecoderConfigArray.get(i18);
            CGLog.i("DecodeCapsDetector codecType:" + decoderConfig2.mCodecType + " view:" + decoderConfig2.mViewType + " height:" + decoderConfig2.mVideoResolution.mHeight + " dec_fps:" + decoderConfig2.mDecStats.f151564l + " rdec_time:" + decoderConfig2.mDecStats.f151560h);
        }
        return i17;
    }

    private void detectDecodeH264Only() {
        detectDecodeCapsModule(16, "SurfaceView", 60, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 55.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "SurfaceView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                if (decStatistics2.f151564l >= 55.0d && decStatistics2.f151560h < 50.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                    return;
                }
            }
            detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 55.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "TextureView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                if (decStatistics4.f151564l >= 55.0d && decStatistics4.f151560h < 50.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                }
            }
            detectDecodeCapsModule(16, selectBestConfig().mViewType, 30, this.V720P);
            this.mBestDecoderConfig = selectBestConfig();
            return;
        }
        detectDecodeCapsModule(16, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics5 = this.mStats;
        if (decStatistics5.f151564l >= 28.0d && decStatistics5.f151560h < 50.0d) {
            this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
        } else {
            detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
            this.mBestDecoderConfig = selectBestConfig();
        }
    }

    private void detectDecodeH264ToH265() {
        detectDecodeCapsModule(17, "SurfaceView", 60, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 55.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(17, "SurfaceView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                if (decStatistics2.f151564l >= 55.0d && decStatistics2.f151560h < 50.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                }
            }
            detectDecodeCapsModule(17, "TextureView", 60, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 55.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(17, "TextureView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                if (decStatistics4.f151564l >= 55.0d && decStatistics4.f151560h < 50.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    return;
                }
            }
            detectDecodeCapsModule(selectBestConfigWithFPS().mCodecType, selectBestConfigWithDecodeTime().mViewType, 30, this.V720P);
            this.mBestDecoderConfig = selectBestConfig();
            return;
        }
        int i3 = selectBestConfig().mCodecType;
        detectDecodeCapsModule(i3, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics5 = this.mStats;
        if (decStatistics5.f151564l >= 28.0d && decStatistics5.f151560h < 50.0d) {
            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
        } else {
            detectDecodeCapsModule(i3, "TextureView", 30, this.V720P);
            this.mBestDecoderConfig = selectBestConfig();
        }
    }

    private void detectDecodeH265ToH264() {
        detectDecodeCapsModule(16, "SurfaceView", 60, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 55.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "SurfaceView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                if (decStatistics2.f151564l >= 55.0d && decStatistics2.f151560h < 50.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                }
            }
            detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 55.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "TextureView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                if (decStatistics4.f151564l >= 55.0d && decStatistics4.f151560h < 50.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    return;
                }
            }
            detectDecodeCapsModule(selectBestConfigWithFPS().mCodecType, selectBestConfigWithDecodeTime().mViewType, 30, this.V720P);
            this.mBestDecoderConfig = selectBestConfig();
            return;
        }
        int i3 = selectBestConfig().mCodecType;
        detectDecodeCapsModule(i3, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics5 = this.mStats;
        if (decStatistics5.f151564l >= 28.0d && decStatistics5.f151560h < 50.0d) {
            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
        } else {
            detectDecodeCapsModule(i3, "TextureView", 30, this.V1080P);
            this.mBestDecoderConfig = selectBestConfig();
        }
    }

    private void detectDecodeH265ToH264Only720p30fps(boolean z16) {
        CGLog.i("detectDecodeH265ToH264Only720p30fps");
        int size = this.mDecoderConfigArray.size();
        int i3 = 16;
        detectDecodeCapsModule(16, "SurfaceView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 28.0d) {
            if (decStatistics.f151560h < 50.0d) {
                this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 0);
                return;
            }
            detectDecodeCapsModule(16, "TextureView", 30, this.V720P);
            VDecoder.DecStatistics decStatistics2 = this.mStats;
            if (decStatistics2.f151564l >= 28.0d && decStatistics2.f151560h < 50.0d) {
                this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 1);
                return;
            } else {
                this.mBestDecoderConfig = selectBestConfig();
                return;
            }
        }
        if (!z16) {
            i3 = selectBestConfigWithFPS().mCodecType;
        }
        detectDecodeCapsModule(i3, "TextureView", 30, this.V720P);
        VDecoder.DecStatistics decStatistics3 = this.mStats;
        if (decStatistics3.f151564l >= 28.0d && decStatistics3.f151560h < 50.0d) {
            this.mBestDecoderConfig = this.mDecoderConfigArray.get(size + 1);
        } else {
            this.mBestDecoderConfig = selectBestConfig();
        }
    }

    private void detectDecodePreferH264() {
        detectDecodeCapsModule(16, "SurfaceView", 60, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 55.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "SurfaceView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                if (decStatistics2.f151564l >= 55.0d && decStatistics2.f151560h < 50.0d) {
                    detectDecodeCapsModule(17, "SurfaceView", 60, this.V1080P);
                    if (this.mDecoderConfigArray.get(1).compareTo(this.mDecoderConfigArray.get(2))) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                        return;
                    } else {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                        return;
                    }
                }
                this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                return;
            }
            detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 55.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(16, "TextureView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                if (decStatistics4.f151564l >= 55.0d && decStatistics4.f151560h < 50.0d) {
                    detectDecodeCapsModule(17, "SurfaceView", 60, this.V1080P);
                    if (this.mDecoderConfigArray.get(2).compareTo(this.mDecoderConfigArray.get(3))) {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                        return;
                    } else {
                        this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                        return;
                    }
                }
                this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                return;
            }
            detectDecodeH264ToH265();
            return;
        }
        detectDecodeH264ToH265();
    }

    private void detectDecodePreferH265() {
        detectDecodeCapsModule(17, "SurfaceView", 60, this.V720P);
        VDecoder.DecStatistics decStatistics = this.mStats;
        if (decStatistics.f151564l >= 55.0d) {
            if (decStatistics.f151560h < 50.0d) {
                detectDecodeCapsModule(17, "SurfaceView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics2 = this.mStats;
                if (decStatistics2.f151564l >= 55.0d) {
                    double d16 = decStatistics2.f151560h;
                    if (d16 < 50.0d) {
                        if (d16 < 20.0d) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                            return;
                        }
                        detectDecodeCapsModule(16, "SurfaceView", 60, this.V1080P);
                        if (d16 < this.mStats.f151560h) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                            return;
                        } else {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                            return;
                        }
                    }
                }
                double d17 = this.mDecoderConfigArray.get(0).mDecStats.f151560h;
                if (d17 < 20.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                    return;
                }
                detectDecodeCapsModule(16, "SurfaceView", 60, this.V720P);
                if (d17 < this.mStats.f151560h) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(0);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                    return;
                }
            }
            detectDecodeCapsModule(17, "TextureView", 60, this.V720P);
            VDecoder.DecStatistics decStatistics3 = this.mStats;
            if (decStatistics3.f151564l >= 55.0d && decStatistics3.f151560h < 50.0d) {
                detectDecodeCapsModule(17, "TextureView", 60, this.V1080P);
                VDecoder.DecStatistics decStatistics4 = this.mStats;
                if (decStatistics4.f151564l >= 55.0d) {
                    double d18 = decStatistics4.f151560h;
                    if (d18 < 50.0d) {
                        if (d18 < 20.0d) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                            return;
                        }
                        detectDecodeCapsModule(16, "TextureView", 60, this.V1080P);
                        if (d18 < this.mStats.f151560h) {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(2);
                            return;
                        } else {
                            this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                            return;
                        }
                    }
                }
                double d19 = this.mDecoderConfigArray.get(1).mDecStats.f151560h;
                if (d19 < 20.0d) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                }
                detectDecodeCapsModule(16, "TextureView", 60, this.V720P);
                if (d19 < this.mStats.f151560h) {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(1);
                    return;
                } else {
                    this.mBestDecoderConfig = this.mDecoderConfigArray.get(3);
                    return;
                }
            }
            detectDecodeH265ToH264();
            return;
        }
        detectDecodeH265ToH264();
    }

    public static void downloadDetectData(String str) {
        downloadHttpUrl(DETECT_DATA_HYPERLINKS, str + "/", "detectVideo.zip");
    }

    public static boolean downloadHttpUrl(String str, String str2, String str3) {
        try {
            isDownloading = true;
            URL url = new URL(str);
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str2 + str3);
            if (file2.exists()) {
                CGLog.i(str3 + " file has exists");
            } else {
                CGLog.i("begin downloading file: " + str3);
                FileUtils.copyURLToFile(url, file2);
                CGLog.i("finish downloading file: " + str3);
            }
            isDownloading = false;
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static int getDetectTimes() {
        return sDetectTimes;
    }

    private Surface getDisplaySurface(String str) {
        int i3 = 0;
        if (str.equals("SurfaceView")) {
            Handler handler = this.mHandler;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 1;
                this.mHandler.sendMessage(obtainMessage);
            }
            Surface surface = this.mSurfaceDisplay;
            if (surface != null) {
                return surface;
            }
            this.mSurfaceDisplay = this.mSurfaceView.getHolder().getSurface();
            while (!this.mSurfaceDisplay.isValid() && i3 < 30) {
                i3++;
                try {
                    CGLog.i("DecodeCapsDetector surfaceView is invalid, count = " + i3);
                    LockMethodProxy.sleep(20L);
                } catch (Exception unused) {
                }
            }
            return this.mSurfaceDisplay;
        }
        if (str.equals("TextureView")) {
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                Message obtainMessage2 = handler2.obtainMessage();
                obtainMessage2.what = 2;
                this.mHandler.sendMessage(obtainMessage2);
            }
            Surface surface2 = this.mTextureDisplay;
            if (surface2 != null) {
                return surface2;
            }
            if (this.mTextureView.isAvailable()) {
                this.mTextureDisplay = new Surface(this.mTextureView.getSurfaceTexture());
                return this.mTextureDisplay;
            }
            while (!this.mTextureView.isAvailable() && i3 < 30) {
                i3++;
                try {
                    CGLog.i("DecodeCapsDetector textureView is not available, count = " + i3);
                    LockMethodProxy.sleep(20L);
                } catch (Exception e16) {
                    CGLog.i("DecodeCapsDetector mTextureView isAvailable? " + e16.toString());
                }
            }
            this.mTextureDisplay = new Surface(this.mTextureView.getSurfaceTexture());
            return this.mTextureDisplay;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getScreenWidthHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mCtx.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mScreenWidth = displayMetrics.widthPixels;
    }

    private byte[] getSpecificStreamData(int i3, int i16, VideoResulotion videoResulotion) {
        int i17;
        if (i3 != 16) {
            if (i3 != 17) {
                return null;
            }
            if (videoResulotion.isEqual(this.V720P)) {
                i17 = 2;
            } else {
                if (videoResulotion.isEqual(this.V1080P)) {
                    i17 = 3;
                }
                i17 = -1;
            }
        } else if (videoResulotion.isEqual(this.V720P)) {
            i17 = 0;
        } else {
            if (videoResulotion.isEqual(this.V1080P)) {
                i17 = 1;
            }
            i17 = -1;
        }
        CGLog.i("DecodeCapsDetector index: " + i17 + " codeType:" + i3 + " frame rate:" + i16 + " height:" + videoResulotion.mHeight);
        StreamsInfo streamsInfo = this.mStreamInfDataset[i17];
        if (streamsInfo.isLoaded) {
            CGLog.i("DecodeCapsDetector " + this.mStreamNames[i17] + " has loaded");
            return this.mStreamInfDataset[i17].data;
        }
        if (!streamsInfo.isDownloaded) {
            if (downloadHttpUrl(DETECT_DATA_HYPERLINKS, this.mCtx.getFilesDir().getPath() + "/", "detectVideo.zip")) {
                try {
                    unZipFile(this.mCtx.getFilesDir().getPath() + "/detectVideo.zip", this.mCtx.getFilesDir().getPath());
                    CGLog.i("DecodeCapsDetector zip file decompression successfully");
                    int i18 = 0;
                    while (true) {
                        StreamsInfo[] streamsInfoArr = this.mStreamInfDataset;
                        if (i18 >= streamsInfoArr.length) {
                            break;
                        }
                        streamsInfoArr[i18].isDownloaded = true;
                        i18++;
                    }
                } catch (Exception unused) {
                    CGLog.i("DecodeCapsDetector zip file decompression failed");
                }
            } else {
                CGLog.e("DecodeCapsDetector https://gamer.qpic.cn/activity/detectVideoV1.0.zip file download failed");
            }
        }
        if (!this.mStreamInfDataset[i17].isDownloaded) {
            return null;
        }
        String str = this.mCtx.getFilesDir().getPath() + "/" + this.mStreamNames[i17];
        CGLog.i("DecodeCapsDetector " + str + " has downloaded");
        byte[] loadStreamData = loadStreamData(str, 0);
        CGLog.i("DecodeCapsDetector success to load stream for " + str);
        StreamsInfo streamsInfo2 = this.mStreamInfDataset[i17];
        streamsInfo2.data = loadStreamData;
        streamsInfo2.isLoaded = true;
        return loadStreamData;
    }

    private void loadDetectDataIfExist() {
        if (this.mCtx == null) {
            return;
        }
        String str = this.mCtx.getFilesDir().getPath() + "/detectVideo.zip";
        File file = new File(str);
        int i3 = 0;
        int i16 = 0;
        while (isDownloading && i16 < 3000) {
            i16 += 30;
            try {
                LockMethodProxy.sleep(30L);
                CGLog.i("DecodeCapsDetector downloading detection dataset has taken " + i16 + " ms");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        isDownloading = false;
        if (file.exists()) {
            try {
                unZipFile(str, this.mCtx.getFilesDir().getPath());
                CGLog.i("DecodeCapsDetector load detect data successfully");
                while (true) {
                    StreamsInfo[] streamsInfoArr = this.mStreamInfDataset;
                    if (i3 < streamsInfoArr.length) {
                        streamsInfoArr[i3].isDownloaded = true;
                        i3++;
                    } else {
                        return;
                    }
                }
            } catch (Exception unused) {
                CGLog.i("DecodeCapsDetector zip file decompression failed");
            }
        } else {
            CGLog.i("DecodeCapsDetector detect data does not exist");
        }
    }

    private byte[] loadStreamData(String str, int i3) {
        new VDecoder.DecStatistics();
        File file = new File(str);
        byte[] bArr = null;
        if (!file.exists()) {
            CGLog.i("Stream file " + str + " not exist!");
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            return bArr;
        } catch (Exception e16) {
            CGLog.e("Failed to open " + str + ", exception=" + e16);
            return bArr;
        }
    }

    private DecoderConfig selectBestConfig() {
        DecoderConfig decoderConfig = this.mDecoderConfigArray.get(0);
        for (int i3 = 1; i3 < this.mDecoderConfigArray.size(); i3++) {
            if (this.mDecoderConfigArray.get(i3).compareTo(decoderConfig)) {
                decoderConfig = this.mDecoderConfigArray.get(i3);
            }
        }
        return decoderConfig;
    }

    private DecoderConfig selectBestConfigWithDecodeTime() {
        DecoderConfig decoderConfig = this.mDecoderConfigArray.get(0);
        for (int i3 = 1; i3 < this.mDecoderConfigArray.size(); i3++) {
            if (this.mDecoderConfigArray.get(i3).compareToWithDecodeTime(decoderConfig)) {
                decoderConfig = this.mDecoderConfigArray.get(i3);
            }
        }
        return decoderConfig;
    }

    private DecoderConfig selectBestConfigWithFPS() {
        DecoderConfig decoderConfig = this.mDecoderConfigArray.get(0);
        for (int i3 = 1; i3 < this.mDecoderConfigArray.size(); i3++) {
            if (this.mDecoderConfigArray.get(i3).compareToWithFPS(decoderConfig)) {
                decoderConfig = this.mDecoderConfigArray.get(i3);
            }
        }
        return decoderConfig;
    }

    private void setBestConfig() {
        String str;
        DecoderConfig decoderConfig = this.mBestDecoderConfig;
        if (decoderConfig.mCodecType == 17) {
            str = "H265";
        } else {
            str = "H264";
        }
        this.mBestCodec = str;
        this.mBestView = decoderConfig.mViewType;
        this.mBestResolution = decoderConfig.mVideoResolution;
        this.mBestFrameRate = decoderConfig.mFrameRate;
        VDecoder.DecStatistics decStatistics = decoderConfig.mDecStats;
        this.mBestAvgDecodeFramerate = decStatistics.f151564l;
        this.mBestAvgDecodeTime = decStatistics.f151560h;
        CGLog.i("DecodeCapsDetector best Codec:" + this.mBestCodec + " best View: " + this.mBestView + " best resolution(Height): " + this.mBestResolution.mHeight + " best frame rate:" + this.mBestFrameRate);
    }

    public static void unZipFile(String str, String str2) throws Exception {
        ZipUtils.unZip(new File(str), str2);
    }

    public void detectDecodeCaps() {
        new BaseThread() { // from class: com.tencent.gamematrix.gmcg.webrtc.DecodeCapsDetector.2
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    DecodeCapsDetector.this.getScreenWidthHeight();
                    DecodeCapsDetector.this.mVdecoder = new VDecoder(DecodeCapsDetector.this.mVdecoderLogLevel, true);
                    for (int i3 = 0; i3 < DecodeCapsDetector.this.mCodecTypes.length; i3++) {
                        DecodeCapsDetector.this.mVdecoder.c(DecodeCapsDetector.this.mDecAbility[i3], DecodeCapsDetector.this.mCodecTypes[i3]);
                    }
                    if (DecodeCapsDetector.this.mIsDetect720p30fpsOnly) {
                        CGLog.i("DecodeCapsDetector  detectDecodeCaps720p30fpsOnly()");
                        DecodeCapsDetector.this.detectDecodeCaps720p30fpsOnly();
                    } else if (DecodeCapsDetector.this.mScreenHeight >= 1080) {
                        CGLog.i("DecodeCapsDetector  detectDecodeCapsGe1080()");
                        DecodeCapsDetector.this.detectDecodeCapsGe1080();
                    } else {
                        CGLog.i("DecodeCapsDetector  detectDecodeCapsLt1080();");
                        DecodeCapsDetector.this.detectDecodeCapsLt1080();
                    }
                } catch (Exception e16) {
                    CGLog.i("Exception happened in detection? " + e16.toString());
                }
                if (DecodeCapsDetector.this.mDecCapsCb != null) {
                    if (DecodeCapsDetector.this.mBestResolution != null) {
                        DecodeCapsDetector.this.mDecCapsCb.onDecodeCapsReported(DecodeCapsDetector.this.mBestResolution.mWidth, DecodeCapsDetector.this.mBestResolution.mHeight, DecodeCapsDetector.this.mBestCodec, DecodeCapsDetector.this.mBestView, DecodeCapsDetector.this.mBestFrameRate, DecodeCapsDetector.this.mTunnelStatus, 1, DecodeCapsDetector.this.mBestAvgDecodeTime, DecodeCapsDetector.this.mBestAvgDecodeFramerate);
                    } else {
                        DecodeCapsDetector.this.mDecCapsCb.onDecodeCapsReported(0, 0, HippyReporter.RemoveEngineReason.INVALID, HippyReporter.RemoveEngineReason.INVALID, 0, "", 1, 0.0d, 0.0d);
                    }
                }
            }
        }.start();
    }

    public String getBestCodec() {
        return this.mBestCodec;
    }

    public int getBestFrameRate() {
        return this.mBestFrameRate;
    }

    public int getBestResolution() {
        return this.mBestResolution.mHeight;
    }

    public String getBestView() {
        return this.mBestView;
    }

    public String getTunnelStatus() {
        return this.mTunnelStatus;
    }

    public void setDecodeCapsCallback(DecodeCapsCallback decodeCapsCallback) {
        this.mDecCapsCb = decodeCapsCallback;
    }

    public void setIsDetect720p30fpsOnly(boolean z16) {
        this.mIsDetect720p30fpsOnly = z16;
    }
}
