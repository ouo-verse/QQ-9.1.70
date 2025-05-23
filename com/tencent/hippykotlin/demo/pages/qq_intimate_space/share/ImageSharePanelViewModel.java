package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareContentData;
import com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes37.dex */
public final class ImageSharePanelViewModel {
    public List<String> imageUrls;
    public final MutableState<SharePanelViewModel> sharePanelViewModel;
    public Integer viewTag;

    public ImageSharePanelViewModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void setPanelHidden() {
        this.sharePanelViewModel.getValue().showPanel.setValue(Boolean.FALSE);
    }

    public ImageSharePanelViewModel(List<String> list, Integer num) {
        MutableState<SharePanelViewModel> mutableStateOf$default;
        this.imageUrls = list;
        this.viewTag = num;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new SharePanelViewModel(), null, 2, null);
        this.sharePanelViewModel = mutableStateOf$default;
    }

    public /* synthetic */ ImageSharePanelViewModel(List list, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), null);
    }

    public final void doShareAction(final ShareItem shareItem) {
        int i3 = shareItem.action;
        if (i3 == 2 || i3 == 3) {
            setPanelHidden();
            ((ShareModule) c.f117352a.g().acquireModule("HRShareModule")).doShareAction(shareItem.action, null, new ShareContentData(1, null, null, null, this.imageUrls, null, null, 0, 0, 4078), new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewModel$doShareAction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Integer num) {
                    int intValue = num.intValue();
                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share retCode: ", intValue, ", actionType: "), ShareItem.this.action, KLog.INSTANCE, "ImageSharePanelViewModel");
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (i3 == 9 || i3 == 10) {
            setPanelHidden();
            ((ShareModule) c.f117352a.g().acquireModule("HRShareModule")).doShareAction(shareItem.action, null, new ShareContentData(1, null, null, null, this.imageUrls, null, null, 0, 0, 2030), new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewModel$doShareAction$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Integer num) {
                    int intValue = num.intValue();
                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share retCode: ", intValue, ", actionType: "), ShareItem.this.action, KLog.INSTANCE, "ImageSharePanelViewModel");
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (i3 != 39) {
            if (i3 != 218) {
                return;
            }
            setPanelHidden();
            ((ShareModule) c.f117352a.g().acquireModule("HRShareModule")).doShareAction(shareItem.action, null, new ShareContentData(0, null, "", "", this.imageUrls, null, null, 0, 0, 2018), new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewModel$doShareAction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Integer num) {
                    int intValue = num.intValue();
                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(NearbyMiddlePosterData$Companion$$ExternalSyntheticOutline0.m("share retCode: ", intValue, ", actionType: "), ShareItem.this.action, KLog.INSTANCE, "ImageSharePanelViewModel");
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (this.viewTag != null) {
            long a16 = b.c((b) c.f117352a.g().acquireModule("KRCalendarModule"), 0L, 1, null).a();
            QQCommonNApiModule qQCommonNApiModule = (QQCommonNApiModule) com.tencent.ntcompose.activity.b.a().acquireModule("QQCommonNApiModule");
            Integer num = this.viewTag;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewModel$doShareAction$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        KLog.INSTANCE.e("ImageSharePanelViewModel", "viewToImage fail");
                        Mqq.INSTANCE.getUi().showTips$enumunboxing$("\u4fdd\u5b58\u5931\u8d25", 3);
                    } else {
                        ImageSharePanelViewModel.this.setPanelHidden();
                        Mqq.INSTANCE.getUi().showTips$enumunboxing$("\u4fdd\u5b58\u6210\u529f", 2);
                    }
                    return Unit.INSTANCE;
                }
            };
            qQCommonNApiModule.curModuleName = "QQNearbyModule";
            e eVar = new e();
            eVar.t(HippyHeaderListViewController.VIEW_TAG, intValue);
            eVar.w("saveToAlbum", true);
            eVar.v(WadlProxyConsts.PARAM_FILENAME, "loveTreeImage_" + a16);
            qQCommonNApiModule.asyncToNativeMethod("viewToImage", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.QQCommonNApiModule$viewToImage$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    e eVar3 = eVar2;
                    function1.invoke(eVar3 != null ? eVar3.p("path") : null);
                    return Unit.INSTANCE;
                }
            });
            Unit unit = Unit.INSTANCE;
            qQCommonNApiModule.curModuleName = "";
            return;
        }
        Iterator<String> it = this.imageUrls.iterator();
        while (it.hasNext()) {
            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("imgPath", it.next());
            QQUIModule qQUIModule = (QQUIModule) c.f117352a.g().acquireModule("QQUIModule");
            Function1<e, Unit> function12 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.ImageSharePanelViewModel$doShareAction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    String str;
                    e eVar3 = eVar2;
                    int j3 = eVar3 != null ? eVar3.j("retCode") : -1;
                    if (j3 == 0) {
                        ImageSharePanelViewModel.this.setPanelHidden();
                        Mqq.INSTANCE.getUi().showTips$enumunboxing$("\u4fdd\u5b58\u6210\u529f", 2);
                    } else {
                        KLog.INSTANCE.e("ImageSharePanelViewModel", "save to local fail, retCode: " + j3);
                        MqqUi ui5 = Mqq.INSTANCE.getUi();
                        if (eVar3 == null || (str = eVar3.p("msg")) == null) {
                            str = "\u4fdd\u5b58\u5931\u8d25";
                        }
                        ui5.showTips$enumunboxing$(str, 3);
                    }
                    return Unit.INSTANCE;
                }
            };
            qQUIModule.getClass();
            qQUIModule.toNative(false, "saveImage", m3.toString(), function12, false);
        }
    }
}
