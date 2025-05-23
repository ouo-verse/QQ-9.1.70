package com.tencent.hippykotlin.demo.pages.nearby.common_share;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareContentData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.PosterDataHolder;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyCommonShareHelper$getArkMsgAndShare$1 extends Lambda implements Function3<Integer, String, String, Unit> {
    public final /* synthetic */ Object $config;
    public final /* synthetic */ PosterDataHolder<?> $data;
    public final /* synthetic */ String $photoPath;
    public final /* synthetic */ long $startTs;
    public final /* synthetic */ NearbyCommonShareHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyCommonShareHelper$getArkMsgAndShare$1(long j3, NearbyCommonShareHelper nearbyCommonShareHelper, PosterDataHolder<?> posterDataHolder, Object obj, String str) {
        super(3);
        this.$startTs = j3;
        this.this$0 = nearbyCommonShareHelper;
        this.$data = posterDataHolder;
        this.$config = obj;
        this.$photoPath = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0096  */
    @Override // kotlin.jvm.functions.Function3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit invoke(Integer num, String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        List emptyList;
        boolean isBlank;
        int intValue = num.intValue();
        String str7 = str;
        String str8 = str2;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u83b7\u53d6ark\u6d88\u606f\u8017\u65f6 ");
        m3.append(APICallTechReporterKt.NBPCurrentTime() - this.$startTs);
        m3.append("ms");
        kLog.i("NearbyCommonShareHelper", m3.toString());
        this.this$0.viewModel.setPreparing(false);
        if (intValue != 0) {
            if (!NearbyProUtilsKt.isShowBackendErrorMsg(intValue)) {
                str7 = "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
            }
            this.this$0.onError.invoke(Boolean.FALSE, str7);
        } else {
            PosterDataHolder<?> posterDataHolder = this.$data;
            if (posterDataHolder instanceof NearbyFeedPosterData) {
                NearbyFeedPosterData nearbyFeedPosterData = (NearbyFeedPosterData) posterDataHolder;
                String str9 = nearbyFeedPosterData.feedTitle;
                Object obj = this.$config;
                isBlank = StringsKt__StringsJVMKt.isBlank(str9);
                if (isBlank) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig");
                    str4 = ((NBPThemePosterConfig) obj).getWxShareTitle(nearbyFeedPosterData.userId);
                    str3 = str4;
                    if (this.$data instanceof NearbyFeedPosterData) {
                        str5 = "";
                    } else {
                        Object obj2 = this.$config;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPThemePosterConfig");
                        str5 = ((NBPThemePosterConfig) obj2).getWxShareDesc(((NearbyFeedPosterData) this.$data).userId);
                    }
                    ShareModule shareModule = Utils.INSTANCE.shareModule(this.this$0.pagerId);
                    str6 = this.$photoPath;
                    if (str6 != null || emptyList == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    ShareContentData shareContentData = new ShareContentData(0, str8, str3, str5, emptyList, null, null, 0, 0, 4064);
                    final NearbyCommonShareHelper nearbyCommonShareHelper = this.this$0;
                    shareModule.doShareAction(2, null, shareContentData, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num2) {
                            int intValue2 = num2.intValue();
                            KLog kLog2 = KLog.INSTANCE;
                            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue2, kLog2, "NearbyCommonShareHelper");
                            if (intValue2 == 0) {
                                NearbyCommonShareHelper.this.onSuccess.invoke(1, Boolean.TRUE, null);
                            } else {
                                kLog2.i("NearbyCommonShareHelper", "handleShare: QQ ark share failed or canceled");
                                NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    str3 = str9;
                    if (this.$data instanceof NearbyFeedPosterData) {
                    }
                    ShareModule shareModule2 = Utils.INSTANCE.shareModule(this.this$0.pagerId);
                    str6 = this.$photoPath;
                    if (str6 != null) {
                        emptyList = CollectionsKt__CollectionsJVMKt.listOf(str6);
                    }
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    ShareContentData shareContentData2 = new ShareContentData(0, str8, str3, str5, emptyList, null, null, 0, 0, 4064);
                    final NearbyCommonShareHelper nearbyCommonShareHelper2 = this.this$0;
                    shareModule2.doShareAction(2, null, shareContentData2, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Integer num2) {
                            int intValue2 = num2.intValue();
                            KLog kLog2 = KLog.INSTANCE;
                            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue2, kLog2, "NearbyCommonShareHelper");
                            if (intValue2 == 0) {
                                NearbyCommonShareHelper.this.onSuccess.invoke(1, Boolean.TRUE, null);
                            } else {
                                kLog2.i("NearbyCommonShareHelper", "handleShare: QQ ark share failed or canceled");
                                NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            } else if (!(posterDataHolder instanceof NearbyMiddlePosterData)) {
                str3 = "";
                if (this.$data instanceof NearbyFeedPosterData) {
                }
                ShareModule shareModule22 = Utils.INSTANCE.shareModule(this.this$0.pagerId);
                str6 = this.$photoPath;
                if (str6 != null) {
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                ShareContentData shareContentData22 = new ShareContentData(0, str8, str3, str5, emptyList, null, null, 0, 0, 4064);
                final NearbyCommonShareHelper nearbyCommonShareHelper22 = this.this$0;
                shareModule22.doShareAction(2, null, shareContentData22, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Integer num2) {
                        int intValue2 = num2.intValue();
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue2, kLog2, "NearbyCommonShareHelper");
                        if (intValue2 == 0) {
                            NearbyCommonShareHelper.this.onSuccess.invoke(1, Boolean.TRUE, null);
                        } else {
                            kLog2.i("NearbyCommonShareHelper", "handleShare: QQ ark share failed or canceled");
                            NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
            } else {
                str4 = "\u9644\u8fd1\u7528\u6237";
                str3 = str4;
                if (this.$data instanceof NearbyFeedPosterData) {
                }
                ShareModule shareModule222 = Utils.INSTANCE.shareModule(this.this$0.pagerId);
                str6 = this.$photoPath;
                if (str6 != null) {
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                ShareContentData shareContentData222 = new ShareContentData(0, str8, str3, str5, emptyList, null, null, 0, 0, 4064);
                final NearbyCommonShareHelper nearbyCommonShareHelper222 = this.this$0;
                shareModule222.doShareAction(2, null, shareContentData222, new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Integer num2) {
                        int intValue2 = num2.intValue();
                        KLog kLog2 = KLog.INSTANCE;
                        NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("handleShare: retCode=", intValue2, kLog2, "NearbyCommonShareHelper");
                        if (intValue2 == 0) {
                            NearbyCommonShareHelper.this.onSuccess.invoke(1, Boolean.TRUE, null);
                        } else {
                            kLog2.i("NearbyCommonShareHelper", "handleShare: QQ ark share failed or canceled");
                            NearbyCommonShareHelper.this.viewModel.setPreparing(false);
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }
}
