package com.tencent.hippykotlin.demo.pages.qq_intimate_space.share;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.screenShotResult;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageData;
import com.tencent.ntcompose.activity.b;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import e25.i;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallFlowerCardShareViewModel {
    public final i flower;
    public final LoveWallHomepageData pageData;
    public MutableState<String> screenImagePath;

    public LoveWallFlowerCardShareViewModel(i iVar, LoveWallHomepageData loveWallHomepageData) {
        MutableState<String> mutableStateOf$default;
        this.flower = iVar;
        this.pageData = loveWallHomepageData;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.screenImagePath = mutableStateOf$default;
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
        LoveWallFlowerCardShareViewModel$share$1 loveWallFlowerCardShareViewModel$share$1;
        Object coroutine_suspended;
        int i16;
        LoveWallFlowerCardShareViewModel loveWallFlowerCardShareViewModel;
        List<String> listOf;
        screenShotResult screenshotresult;
        if (continuation instanceof LoveWallFlowerCardShareViewModel$share$1) {
            loveWallFlowerCardShareViewModel$share$1 = (LoveWallFlowerCardShareViewModel$share$1) continuation;
            int i17 = loveWallFlowerCardShareViewModel$share$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                loveWallFlowerCardShareViewModel$share$1.label = i17 - Integer.MIN_VALUE;
                Object obj = loveWallFlowerCardShareViewModel$share$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = loveWallFlowerCardShareViewModel$share$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!(this.screenImagePath.getValue().length() == 0)) {
                        loveWallFlowerCardShareViewModel = this;
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(loveWallFlowerCardShareViewModel.screenImagePath.getValue());
                        imageSharePanelViewModel.imageUrls = listOf;
                        if (b.a().getPageData().getIsAndroid()) {
                            imageSharePanelViewModel.viewTag = Boxing.boxInt(i3);
                        }
                        imageSharePanelViewModel.doShareAction(shareItem);
                        return Unit.INSTANCE;
                    }
                    MqqUi ui5 = Mqq.INSTANCE.getUi();
                    loveWallFlowerCardShareViewModel$share$1.L$0 = this;
                    loveWallFlowerCardShareViewModel$share$1.L$1 = imageSharePanelViewModel;
                    loveWallFlowerCardShareViewModel$share$1.L$2 = shareItem;
                    loveWallFlowerCardShareViewModel$share$1.I$0 = i3;
                    loveWallFlowerCardShareViewModel$share$1.label = 1;
                    obj = ui5.screenShot(i3, loveWallFlowerCardShareViewModel$share$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loveWallFlowerCardShareViewModel = this;
                } else if (i16 == 1) {
                    i3 = loveWallFlowerCardShareViewModel$share$1.I$0;
                    shareItem = loveWallFlowerCardShareViewModel$share$1.L$2;
                    imageSharePanelViewModel = loveWallFlowerCardShareViewModel$share$1.L$1;
                    loveWallFlowerCardShareViewModel = loveWallFlowerCardShareViewModel$share$1.L$0;
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
                    loveWallFlowerCardShareViewModel.screenImagePath.setValue(str);
                }
                listOf = CollectionsKt__CollectionsJVMKt.listOf(loveWallFlowerCardShareViewModel.screenImagePath.getValue());
                imageSharePanelViewModel.imageUrls = listOf;
                if (b.a().getPageData().getIsAndroid()) {
                }
                imageSharePanelViewModel.doShareAction(shareItem);
                return Unit.INSTANCE;
            }
        }
        loveWallFlowerCardShareViewModel$share$1 = new LoveWallFlowerCardShareViewModel$share$1(this, continuation);
        Object obj2 = loveWallFlowerCardShareViewModel$share$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = loveWallFlowerCardShareViewModel$share$1.label;
        if (i16 != 0) {
        }
        screenshotresult = (screenShotResult) obj2;
        if (screenshotresult.retCode == 0) {
        }
    }
}
