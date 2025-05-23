package com.qzone.module.feedcomponent.util;

import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;
import com.tencent.component.media.image.processor.CropByPivotRawProcessor;
import com.tencent.component.media.image.processor.MergeProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.processor.SingleFeedImageProcessor;
import com.tencent.view.FilterEnum;
import tl.h;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CanvasFeedContentUtil {
    public static final float GOLDEN_CUDGEL_RATIO = 1.78f;
    public static final float SINGLE_SMALL_PHOTO_MAX_SCALE = 2.0f;
    public String desc = "";
    public static final int MARGIN_LEFT = j.f(274);
    protected static final int dp5 = (int) j.e(278);
    protected static final int dp7 = (int) j.e(FilterEnum.MIC_PTU_TRANS_ROUHE);
    protected static int screenWidth = FeedGlobalEnv.g().getScreenWidth();
    protected static int maxPicWidth = 0;
    protected static int maxPicHeight = 0;
    static final int SPACE_REDPOCKET_WIDTH = g.a(210.0f);
    static final int SPACE_REDPOCKET_HEIGHT = g.a(250.0f);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class ImageProcessorSupplier {
        public static ImageProcessor supplyMultiMerge(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17, float[] fArr) {
            MergeProcessor mergeProcessor = new MergeProcessor();
            mergeProcessor.addProcessor(supplyMulti(i3, feedPictureInfo, i16, i17));
            mergeProcessor.addProcessor(new RoundCornerProcessor(fArr));
            return mergeProcessor;
        }

        public static ImageProcessor supplySingle(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17, int i18, int i19, boolean z16) {
            return supplySingle(i3, feedPictureInfo, i16, i17, i18, i19, z16, false);
        }

        public static ImageProcessor supplySingleMerge(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17, int i18, int i19, boolean z16, boolean z17, float[] fArr) {
            MergeProcessor mergeProcessor = new MergeProcessor();
            mergeProcessor.addProcessor(supplySingle(i3, feedPictureInfo, i16, i17, i18, i19, z16, z17));
            mergeProcessor.addProcessor(new RoundCornerProcessor(fArr));
            return mergeProcessor;
        }

        public static RawImageProcessor supplySingleRaw(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17) {
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ImageProcessor supplySingle(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17, int i18, int i19, boolean z16, boolean z17) {
            SingleFeedImageProcessor singleFeedImageProcessor;
            if (!feedPictureInfo.l() && !feedPictureInfo.k()) {
                float e16 = feedPictureInfo.e();
                float f16 = feedPictureInfo.f();
                if (feedPictureInfo.h().width != 0 && feedPictureInfo.h().height != 0) {
                    NormalFeedImageProcessor normalFeedImageProcessor = new NormalFeedImageProcessor(i16, i17, e16, f16);
                    normalFeedImageProcessor.setDefaultScaleType(10);
                    int i26 = (CanvasFeedContentUtil.screenWidth - AreaConst.MARGIN_LEFT) - AreaConst.MARGIN_RIGHT;
                    if (z17) {
                        normalFeedImageProcessor.keepOrigScale(true, i26, i26);
                        singleFeedImageProcessor = normalFeedImageProcessor;
                    } else {
                        normalFeedImageProcessor.keepOrigScale(true, i26, (int) (i26 * i.H().r0()));
                        singleFeedImageProcessor = normalFeedImageProcessor;
                    }
                } else {
                    singleFeedImageProcessor = new SingleFeedImageProcessor(i16, i17, e16, f16, z17 ? 1000.0f : 2.0f);
                }
                if (!feedPictureInfo.i()) {
                    return singleFeedImageProcessor;
                }
                FeedPictureInfo.ImageType d16 = feedPictureInfo.d();
                FeedPictureInfo.ImageType imageType = FeedPictureInfo.ImageType.IMAGE_GIF;
                if (d16 != imageType || !feedPictureInfo.i() || feedPictureInfo.d() != imageType) {
                    return singleFeedImageProcessor;
                }
                if (feedPictureInfo.h().width == 0 && feedPictureInfo.h().height == 0) {
                    return new SingleFeedImageProcessor(i16, i17, e16, f16, z17 ? 1000.0f : 2.0f);
                }
                return new ScaleProcessor(i16, i17, true);
            }
            return new NormalFeedImageProcessor(i16, i17);
        }

        public static ImageProcessor supplyMulti(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17) {
            float f16;
            float f17;
            if (feedPictureInfo != null) {
                f16 = feedPictureInfo.e();
                f17 = feedPictureInfo.f();
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
            }
            return new NormalFeedImageProcessor(i16, i17, f16, f17);
        }

        public static RawImageProcessor supplyMultiRaw(int i3, FeedPictureInfo feedPictureInfo, int i16, int i17) {
            float f16;
            float f17;
            if (feedPictureInfo != null) {
                f16 = feedPictureInfo.e();
                f17 = feedPictureInfo.f();
            } else {
                f16 = 0.0f;
                f17 = 0.0f;
            }
            return new CropByPivotRawProcessor(i16, i17, f16, f17);
        }
    }

    public static void debugLog(String str, String str2) {
        com.qzone.proxy.feedcomponent.b.e("MEDIAFRAME-" + str, str2);
    }

    @Deprecated
    public static int[] getSingleDesiredPicSize(FeedPictureInfo feedPictureInfo, int i3, boolean z16) {
        return getSingleDesiredPicSize(feedPictureInfo, i3, z16, null);
    }

    public static int[] getSingleDesiredPicSize(FeedPictureInfo feedPictureInfo, int i3, boolean z16, BusinessFeedData businessFeedData) {
        int i16;
        int i17;
        if (feedPictureInfo.l()) {
            PictureUrl h16 = feedPictureInfo.h();
            if (h16 != null) {
                i16 = h16.width;
                i17 = h16.height;
                if (i16 == 0 || i17 == 0) {
                    i16 = i3 == 1 ? com.qzone.adapter.feedcomponent.b.f41854a : com.qzone.adapter.feedcomponent.b.f41856c;
                    i17 = i3 == 1 ? com.qzone.adapter.feedcomponent.b.f41855b : com.qzone.adapter.feedcomponent.b.f41857d;
                }
            } else {
                i17 = 0;
                i16 = 0;
            }
        } else if (feedPictureInfo.k()) {
            i16 = com.qzone.adapter.feedcomponent.b.f41858e;
            i17 = com.qzone.adapter.feedcomponent.b.f41859f;
        } else {
            int[] picSizeNormal = getPicSizeNormal(feedPictureInfo.h(), i3, z16, businessFeedData);
            i16 = picSizeNormal[0];
            i17 = picSizeNormal[1];
        }
        return new int[]{i16, i17, 200, 200};
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x014b, code lost:
    
        if (r0 != 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x015f, code lost:
    
        r0 = (int) (r0 * (r1 / (r2 * 1.0d)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x015c, code lost:
    
        if (r2 <= r0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01db, code lost:
    
        if (r1 <= r0) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0230, code lost:
    
        if (r1 <= r0) goto L233;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static int[] getPicSizeNormal(PictureUrl pictureUrl, int i3, boolean z16, BusinessFeedData businessFeedData) {
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z17;
        int i26;
        int i27;
        int i28;
        int i29;
        double d16;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47 = AreaConst.MARGIN_LEFT;
        int i48 = AreaConst.MARGIN_RIGHT;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo().isYunYingFeeds()) {
            i47 = 0;
            i48 = 0;
        }
        int i49 = AreaConst.dp10;
        int d06 = i.H().d0();
        boolean z18 = businessFeedData != null && businessFeedData.isForwardFeed();
        if (businessFeedData != null && businessFeedData.isCanvasAd()) {
            int i56 = (screenWidth - i47) - i48;
            return new int[]{i56, (int) (i56 * 0.56f)};
        }
        if (businessFeedData != null && businessFeedData.isSubOfSingleAdvContainerFeed() && !businessFeedData.isSubOfSingleAdvContainerNewStyle()) {
            i16 = AreaConst.commentWidth_Rec;
        } else {
            if (businessFeedData != null && (businessFeedData.isSubOfMultiAdvContainerFeed() || businessFeedData.isSubOfSingleAdvContainerNewStyle())) {
                i18 = AreaConst.cardContainerWidth;
                i19 = AreaConst.CONTAINER_LINE_WIDTH * 2;
            } else if (businessFeedData != null && businessFeedData.getFeedCommInfo().isPicUpLayout()) {
                i16 = AreaConst.feedWidth_Rec - 2;
            } else if (z16) {
                i18 = AreaConst.feedWidth_Rec + 2;
                i19 = AreaConst.f48746dp1;
            } else if (businessFeedData != null && businessFeedData.isLiveVideoFeed() && !i.H().h1()) {
                if (i.H().s1()) {
                    i16 = screenWidth;
                } else {
                    i16 = (screenWidth - i47) - i48;
                }
            } else if (businessFeedData != null && businessFeedData.isAdFeeds() && !businessFeedData.isSingleCardStyle()) {
                i16 = screenWidth;
            } else {
                if (businessFeedData != null && businessFeedData.getFeedCommInfo().isYunYingFeeds()) {
                    i17 = screenWidth;
                } else if (i3 == 0 && businessFeedData != null && businessFeedData.isAdFeeds() && !businessFeedData.isSingleAdvContainerFeed() && businessFeedData.getLocalInfo().canLike && businessFeedData.getLocalInfo().canShare && businessFeedData.getLocalInfo().canComment) {
                    i17 = screenWidth;
                } else if (i3 == 1 && businessFeedData != null && (businessFeedData.getSinglePicAdvStyle() == 4 || businessFeedData.isSingleCardStyle())) {
                    i17 = screenWidth;
                } else if (i3 == 0) {
                    i17 = screenWidth;
                } else {
                    i16 = screenWidth;
                }
                i16 = (i17 - i47) - i48;
            }
            i16 = i18 - i19;
        }
        if (businessFeedData != null && businessFeedData.isLiveVideoFeed()) {
            i37 = Math.round(i16 * i.H().s0());
            float f16 = i37;
            Math.round(i.H().r0() * f16);
            if (businessFeedData.feedType == 2) {
                i39 = pictureUrl.width;
                if (i39 != 0) {
                    i46 = pictureUrl.height;
                }
                i28 = i37;
                i16 = i28;
            } else {
                if (i.H().s1()) {
                    i39 = pictureUrl.width;
                    i46 = pictureUrl.height;
                } else {
                    int i57 = pictureUrl.width;
                    if (i57 != 0 && (i38 = pictureUrl.height) != 0 && i57 != i38) {
                        if (i57 > i38) {
                            i28 = (int) (((f16 * 1.0f) / i57) * i38);
                            i16 = i37;
                        } else {
                            i16 = (int) Math.min(((i57 * i37) * 1.0f) / i38, maxPicWidth);
                            i28 = i37;
                        }
                    }
                }
                i28 = i37;
                i16 = i28;
            }
        } else if (businessFeedData != null && (businessFeedData.isSubOfMultiAdvContainerFeed() || businessFeedData.isSubOfSingleAdvContainerFeed())) {
            if (businessFeedData.isAttach()) {
                i16 = AreaConst.ATTACH_PIC_WIDTH_IN_PX;
            } else if (businessFeedData.isSquareCardStyle()) {
                i16 = AreaConst.SQUARE_CARD_CONTAINER_WIDTH_IN_PX - (AreaConst.CONTAINER_LINE_WIDTH * 2);
            } else {
                i37 = (int) (i16 / 1.78f);
                if (businessFeedData.isLiveVideoFeed()) {
                    int i58 = pictureUrl.width;
                    int i59 = pictureUrl.height;
                    if (i58 > i59) {
                        i37 = (int) (i59 * (i16 / (i58 * 1.0d)));
                    }
                }
                if (businessFeedData.isLiveVideoFeed()) {
                    i29 = pictureUrl.width;
                    i36 = pictureUrl.height;
                }
                i28 = i37;
            }
            i37 = i16;
            if (businessFeedData.isLiveVideoFeed()) {
            }
            i28 = i37;
        } else if (businessFeedData != null && (businessFeedData.getFeedCommInfo().isYunYingFeeds() || businessFeedData.isAdFeeds())) {
            i29 = pictureUrl.width;
            if (i29 != 0) {
                i36 = pictureUrl.height;
                d16 = i36;
                i28 = (int) (d16 * (i16 / (i29 * 1.0d)));
            }
            i28 = i16;
        } else if (z16) {
            i28 = (int) (i16 / 1.78f);
        } else {
            int i65 = pictureUrl.width;
            if (i65 != 0 && pictureUrl.height != 0) {
                if ((i3 == 1 && i65 * d06 >= i16) || (businessFeedData != null && businessFeedData.isAdFeeds())) {
                    if (businessFeedData != null && businessFeedData.isAdFeeds()) {
                        i29 = pictureUrl.width;
                        i36 = pictureUrl.height;
                    } else {
                        i29 = pictureUrl.width;
                        int i66 = pictureUrl.height;
                        if (i29 < i66) {
                            if (i66 > i29 * 1.8d) {
                                if (z18) {
                                    i47 = i49;
                                }
                                i16 = Math.min(i29, i16 - (i47 * 2));
                                i28 = Math.min(pictureUrl.height, (int) (i16 * 1.6d));
                            } else {
                                double d17 = i66;
                                i28 = screenWidth;
                                if (d17 > i28 * 1.02d) {
                                    i16 = (int) (((i29 * i28) * 1.0d) / i66);
                                } else {
                                    i16 = i29;
                                    i28 = i66;
                                }
                            }
                        } else if (i29 > i66 * 3) {
                            i16 = Math.min(i16, i66 * 3);
                            i28 = pictureUrl.height;
                        } else {
                            d16 = i66;
                            i28 = (int) (d16 * (i16 / (i29 * 1.0d)));
                        }
                    }
                } else {
                    if (businessFeedData != null && businessFeedData.getCellLuckyMoney() != null) {
                        maxPicWidth = i.H().y0(SPACE_REDPOCKET_WIDTH);
                        maxPicHeight = i.H().x0(SPACE_REDPOCKET_HEIGHT);
                        z17 = true;
                    } else {
                        if (businessFeedData != null && businessFeedData.isNewHandBlogFeed()) {
                            int round = Math.round(i16 * i.H().s0());
                            maxPicWidth = round;
                            maxPicHeight = round;
                        } else {
                            int round2 = Math.round(i16 * i.H().s0());
                            maxPicWidth = round2;
                            maxPicHeight = Math.round(round2 * i.H().r0());
                        }
                        z17 = false;
                    }
                    debugLog("maxPicWidth", String.valueOf(maxPicWidth));
                    debugLog("maxPicHeight", String.valueOf(maxPicHeight));
                    if (i.H().m1() && !z17) {
                        int[] applyNewSinglePicRule = applyNewSinglePicRule(pictureUrl.height, pictureUrl.width, i16);
                        i16 = applyNewSinglePicRule[0];
                        i28 = applyNewSinglePicRule[1];
                    } else {
                        float f17 = (maxPicWidth * 1.0f) / pictureUrl.width;
                        float f18 = (maxPicHeight * 1.0f) / pictureUrl.height;
                        debugLog("w", String.valueOf(f17));
                        debugLog(h.F, String.valueOf(f18));
                        if ((f17 < f18 && f17 >= 1.0f && f18 >= 1.0f) || ((f17 < f18 && f17 < 1.0f && f18 < 1.0f) || (f17 < 1.0f && f18 > 1.0f))) {
                            debugLog("\u5148\u8ba1\u7b97", "w");
                            int i67 = pictureUrl.width;
                            int i68 = pictureUrl.height;
                            if (i67 <= i68 * 5) {
                                int i69 = i67 * d06;
                                int i75 = maxPicWidth;
                                i16 = i69 >= i75 ? i75 : d06 * i67;
                                i28 = (int) (((i16 * 1.0f) / i67) * i68);
                            } else {
                                i16 = maxPicWidth;
                                i28 = i16 / 5;
                            }
                        } else {
                            debugLog("\u5148\u8ba1\u7b97", h.F);
                            int i76 = pictureUrl.height;
                            int i77 = pictureUrl.width;
                            if (i76 <= i77 * 5) {
                                int i78 = i76 * d06;
                                int i79 = maxPicHeight;
                                i26 = i78 >= i79 ? i79 : d06 * i76;
                                i27 = (int) (((i26 * 1.0f) / i76) * i77);
                            } else {
                                i26 = maxPicHeight;
                                i27 = i26 / 5;
                            }
                            int i85 = i26;
                            i16 = i27;
                            i28 = i85;
                        }
                    }
                }
            }
            i28 = i16;
        }
        return new int[]{i16, i28};
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        if (r3 > r5) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] applyNewSinglePicRule(float f16, float f17, float f18) {
        float f19 = f16 <= f17 ? f18 : f18 / 2.0f;
        double d16 = f16 / f17;
        if (d16 > 1.0d && d16 <= 1.1d) {
            f17 = f16;
            f19 = f18;
        }
        if (f17 >= f16 * 5.0f) {
            f18 = f19 / 5.0f;
        } else if (f16 >= f17 * 5.0f) {
            f19 = f18 / 5.0f;
        } else {
            float f26 = f17 * 2.0f;
            float f27 = f26 / f19;
            float f28 = f16 * 2.0f;
            float f29 = f28 / f18;
            double d17 = f27;
            if (d17 < 0.75d) {
                double d18 = f29;
                if (d18 < 0.75d) {
                    if (d17 < 0.5d && d18 < 0.5d) {
                        f19 = f26;
                        f18 = f28;
                    } else if (f27 > f29) {
                        f19 /= 2.0f;
                        f18 = (f19 / f17) * f16;
                    } else {
                        f18 /= 2.0f;
                        f19 = (f18 / f16) * f17;
                    }
                }
            }
        }
        return new int[]{(int) f19, (int) f18};
    }
}
