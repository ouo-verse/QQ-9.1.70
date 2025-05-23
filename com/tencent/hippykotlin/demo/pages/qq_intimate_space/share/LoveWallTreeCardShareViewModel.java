package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.screenShotResult;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.FilamentSceneMessageChannelModule;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageData;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.MathUtilsKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.activity.b;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import d25.c;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallTreeCardShareViewModel {
    public int achieveDays;
    public final TreeCardShareConfig config;
    public MutableState<Boolean> hasTreeImage;
    public final LoveWallHomepageData pageData;
    public MutableState<String> screenImagePath;
    public float treeHeight;
    public byte[] treeImageRawData;

    public LoveWallTreeCardShareViewModel(TreeCardShareConfig treeCardShareConfig, LoveWallHomepageData loveWallHomepageData, boolean z16) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<String> mutableStateOf$default2;
        this.config = treeCardShareConfig;
        this.pageData = loveWallHomepageData;
        this.treeHeight = treeCardShareConfig.getTreeHeight();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.hasTreeImage = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.screenImagePath = mutableStateOf$default2;
        Long achieveTime = treeCardShareConfig.getAchieveTime();
        if (achieveTime != null) {
            this.achieveDays = ((int) ((Mqq.INSTANCE.getUtil().currentTime() - (achieveTime.longValue() * 1000)) / 86400000)) + 1;
        }
        if (z16) {
            fetchTreeImageData(new Function1<byte[], Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardShareViewModel.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(byte[] bArr) {
                    LoveWallTreeCardShareViewModel.this.hasTreeImage.setValue(Boolean.TRUE);
                    LoveWallTreeCardShareViewModel.this.treeImageRawData = bArr;
                    return Unit.INSTANCE;
                }
            });
        }
        this.treeHeight = MathUtilsKt.roundToDecimalPlaces(this.treeHeight);
    }

    public final void fetchTreeImageData(final Function1<? super byte[], Unit> function1) {
        ((FilamentSceneMessageChannelModule) b.a().acquireModule("FilamentSceneMessageChannelModule")).postMessage("SceneCommon.ScreenshotPng", i.d(new d25.b(0L, Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(0.0f))), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.share.LoveWallTreeCardShareViewModel$fetchTreeImageData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                byte[] bArr = obj instanceof byte[] ? (byte[]) obj : null;
                if (bArr == null) {
                    KLog.INSTANCE.e("LoveWallTreeCardShareViewModel", "fetchTreeImageData rsp data is null");
                } else {
                    a aVar = ((c) i.b(new c(true, 4), bArr)).f392719f;
                    if (aVar != null) {
                        Function1<byte[], Unit> function12 = function1;
                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("get tree pixel, size: "), aVar.f30291a.length, KLog.INSTANCE, "LoveWallTreeCardShareViewModel");
                        function12.invoke(aVar.f30291a);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object share(int i3, ImageSharePanelViewModel imageSharePanelViewModel, ShareItem shareItem, Continuation<? super Unit> continuation) {
        LoveWallTreeCardShareViewModel$share$1 loveWallTreeCardShareViewModel$share$1;
        Object coroutine_suspended;
        int i16;
        LoveWallTreeCardShareViewModel loveWallTreeCardShareViewModel;
        List<String> listOf;
        screenShotResult screenshotresult;
        if (continuation instanceof LoveWallTreeCardShareViewModel$share$1) {
            loveWallTreeCardShareViewModel$share$1 = (LoveWallTreeCardShareViewModel$share$1) continuation;
            int i17 = loveWallTreeCardShareViewModel$share$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                loveWallTreeCardShareViewModel$share$1.label = i17 - Integer.MIN_VALUE;
                Object obj = loveWallTreeCardShareViewModel$share$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = loveWallTreeCardShareViewModel$share$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!(this.screenImagePath.getValue().length() == 0)) {
                        loveWallTreeCardShareViewModel = this;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(loveWallTreeCardShareViewModel.screenImagePath.getValue());
                        imageSharePanelViewModel.imageUrls = listOf;
                        if (b.a().getPageData().getIsAndroid()) {
                            imageSharePanelViewModel.viewTag = Boxing.boxInt(i3);
                        }
                        imageSharePanelViewModel.doShareAction(shareItem);
                        return Unit.INSTANCE;
                    }
                    MqqUi ui5 = Mqq.INSTANCE.getUi();
                    loveWallTreeCardShareViewModel$share$1.L$0 = this;
                    loveWallTreeCardShareViewModel$share$1.L$1 = imageSharePanelViewModel;
                    loveWallTreeCardShareViewModel$share$1.L$2 = shareItem;
                    loveWallTreeCardShareViewModel$share$1.I$0 = i3;
                    loveWallTreeCardShareViewModel$share$1.label = 1;
                    obj = ui5.screenShot(i3, loveWallTreeCardShareViewModel$share$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loveWallTreeCardShareViewModel = this;
                } else if (i16 == 1) {
                    i3 = loveWallTreeCardShareViewModel$share$1.I$0;
                    shareItem = loveWallTreeCardShareViewModel$share$1.L$2;
                    imageSharePanelViewModel = loveWallTreeCardShareViewModel$share$1.L$1;
                    loveWallTreeCardShareViewModel = loveWallTreeCardShareViewModel$share$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                screenshotresult = (screenShotResult) obj;
                if (screenshotresult.retCode == 0) {
                    Mqq.INSTANCE.getUi().showTips$enumunboxing$(ShareJsPlugin.ERRMSG_INVITE_REQUIRE, 3);
                    return Unit.INSTANCE;
                }
                String str = screenshotresult.imgPath;
                if (str != null) {
                    loveWallTreeCardShareViewModel.screenImagePath.setValue(str);
                }
                listOf = CollectionsKt__CollectionsJVMKt.listOf(loveWallTreeCardShareViewModel.screenImagePath.getValue());
                imageSharePanelViewModel.imageUrls = listOf;
                if (b.a().getPageData().getIsAndroid()) {
                }
                imageSharePanelViewModel.doShareAction(shareItem);
                return Unit.INSTANCE;
            }
        }
        loveWallTreeCardShareViewModel$share$1 = new LoveWallTreeCardShareViewModel$share$1(this, continuation);
        Object obj2 = loveWallTreeCardShareViewModel$share$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = loveWallTreeCardShareViewModel$share$1.label;
        if (i16 != 0) {
        }
        screenshotresult = (screenShotResult) obj2;
        if (screenshotresult.retCode == 0) {
        }
    }
}
