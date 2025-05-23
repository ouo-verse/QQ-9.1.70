package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3FrameInfoParse;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Mp3SeekTable implements SeekTable {
    private final Mp3FrameInfoParse.Mp3Info mInfo = new Mp3FrameInfoParse.Mp3Info();

    private static long timeToBytePositionInCbr(Mp3FrameInfoParse.Mp3Info mp3Info, long j3) {
        int i3;
        if (mp3Info != null && (i3 = mp3Info.bit_rate) > 0 && j3 >= 0) {
            long j16 = (i3 / 8) * j3;
            int i16 = mp3Info.idv2Size;
            if (i16 > 0) {
                return j16 + i16;
            }
            return j16;
        }
        return -1L;
    }

    private static long timeToBytePositionInVBRIVbr(Mp3FrameInfoParse.Mp3Info mp3Info, long j3) {
        long[] jArr;
        long j16;
        if (mp3Info != null && (jArr = mp3Info.toc_table) != null) {
            long j17 = mp3Info.fileLengthInBytes;
            if (j17 > 0) {
                long j18 = mp3Info.firstFramePosition;
                if (j18 >= 0) {
                    long j19 = mp3Info.duration;
                    if (j19 > 0 && j3 >= 0) {
                        int i3 = mp3Info.entry_count;
                        int i16 = i3 + 1;
                        int i17 = (int) (((j3 * 1.0d) / j19) * i16);
                        if (i17 >= 0) {
                            j18 = jArr[i17];
                        }
                        if (i17 < i3) {
                            j17 = jArr[i17 + 1];
                        }
                        long j26 = i16;
                        long j27 = (i17 * j19) / j26;
                        long j28 = ((i17 + 1) * j19) / j26;
                        if (j17 == j18) {
                            j16 = 0;
                        } else {
                            j16 = (long) ((((j17 - j18) * 1.0d) * (j3 - j27)) / (j28 - j27));
                        }
                        return j18 + j16;
                    }
                    return -1L;
                }
                return -1L;
            }
            return -1L;
        }
        return -1L;
    }

    private static long timeToBytePositionInXingVbr(Mp3FrameInfoParse.Mp3Info mp3Info, long j3) {
        long[] jArr;
        float f16;
        float f17;
        if (mp3Info != null && (jArr = mp3Info.toc_table) != null) {
            long j16 = mp3Info.fileLengthInBytes;
            if (j16 > 0) {
                long j17 = mp3Info.firstFramePosition;
                if (j17 >= 0) {
                    long j18 = mp3Info.duration;
                    if (j18 >= 0 && j3 >= 0) {
                        double d16 = (j3 * 100.0d) / j18;
                        double d17 = 0.0d;
                        if (d16 > 0.0d) {
                            if (d16 >= 100.0d) {
                                d17 = 256.0d;
                            } else {
                                int i3 = (int) d16;
                                if (i3 == 0) {
                                    f16 = 0.0f;
                                } else {
                                    f16 = (float) jArr[i3];
                                }
                                if (i3 < 99) {
                                    f17 = (float) jArr[i3 + 1];
                                } else {
                                    f17 = 256.0f;
                                }
                                d17 = f16 + ((f17 - f16) * (d16 - i3));
                            }
                        }
                        long round = Math.round(d17 * 0.00390625d * j16) + j17;
                        long j19 = (j17 + j16) - 1;
                        int i16 = mp3Info.idv2Size;
                        if (i16 > 0) {
                            j19 -= i16;
                        }
                        if (round >= j19) {
                            return j19;
                        }
                        return round;
                    }
                    return -1L;
                }
                return -1L;
            }
            return -1L;
        }
        return -1L;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) throws IOException {
        Mp3FrameInfoParse.parseFrameInfo(new TrackPositionDataSource(iDataSource), this.mInfo);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j3) {
        if (j3 < 0) {
            return -1L;
        }
        Mp3FrameInfoParse.Mp3Info mp3Info = this.mInfo;
        int i3 = mp3Info.VBRType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return -1L;
                }
                return timeToBytePositionInXingVbr(mp3Info, j3);
            }
            return timeToBytePositionInVBRIVbr(mp3Info, j3);
        }
        return timeToBytePositionInCbr(mp3Info, j3);
    }
}
