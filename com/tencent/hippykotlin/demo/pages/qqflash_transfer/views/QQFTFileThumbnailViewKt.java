package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.resource.QQFTIconConstant;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.LoadFailureParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.h;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import ws3.ab;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFileThumbnailViewKt {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, androidx.compose.runtime.MutableState] */
    /* renamed from: QQFTFileThumbnailView-CvonfEE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m125QQFTFileThumbnailViewCvonfEE(final i iVar, final int i3, final i iVar2, final QQFTFileDetailItemVM qQFTFileDetailItemVM, Composer composer, final int i16) {
        ?? mutableStateOf$default;
        boolean z16;
        String str;
        Map mutableMapOf;
        ScopeUpdateScope endRestartGroup;
        String str2;
        boolean startsWith$default;
        boolean z17;
        boolean startsWith$default2;
        Composer startRestartGroup = composer.startRestartGroup(-1117813714);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117813714, i16, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileThumbnailView (QQFTFileThumbnailView.kt:31)");
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(qQFTFileDetailItemVM.thumbnailUrl.getValue(), null, 2, null);
        objectRef.element = mutableStateOf$default;
        ab abVar = qQFTFileDetailItemVM.fileDetail;
        if (qQFTFileDetailItemVM.thumbnailUrl.getValue().length() > 0) {
            String value = qQFTFileDetailItemVM.thumbnailUrl.getValue();
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(value, "https:", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(value, "http:", false, 2, null);
                if (!startsWith$default2) {
                    z17 = false;
                    if (z17) {
                        if (!(qQFTFileDetailItemVM.fileStatus.getValue().intValue() == 5)) {
                            z16 = true;
                            int i17 = 11;
                            if (z16) {
                                startRestartGroup.startReplaceableGroup(-2084392955);
                                Integer value2 = qQFTFileDetailItemVM.compressStatus.getValue();
                                if (abVar != null && abVar.f446159j == 4) {
                                    if ((value2 == null || value2.intValue() != 3) && (value2 == null || value2.intValue() != 4)) {
                                        r11 = false;
                                    }
                                    if (r11) {
                                        str2 = "data:image/png;base64,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";
                                    } else {
                                        str2 = QQFTIconConstant.FILE_TYPE_ICONS[4];
                                    }
                                } else {
                                    String[] strArr = QQFTIconConstant.FILE_TYPE_ICONS;
                                    if (abVar != null && abVar.f446155f) {
                                        i17 = 25;
                                    } else {
                                        if ((abVar != null ? Integer.valueOf(abVar.f446159j) : null) != null) {
                                            i17 = abVar.f446159j;
                                        }
                                    }
                                    str2 = strArr[i17];
                                }
                                ImageKt.a(null, null, null, null, null, iVar, null, h.INSTANCE.c(), null, null, str2, null, null, null, null, null, null, null, null, null, null, startRestartGroup, 12845056, 0, 0, 2095967);
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                startRestartGroup.startReplaceableGroup(-2084392764);
                                String str3 = (String) ((MutableState) objectRef.element).getValue();
                                String str4 = abVar != null ? abVar.f446151b : null;
                                if (abVar != null && abVar.f446159j == 26) {
                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_w2bMwC4JyjB.png";
                                } else {
                                    String[] strArr2 = QQFTIconConstant.FILE_TYPE_ICONS_URL;
                                    if (abVar != null && abVar.f446155f) {
                                        i17 = 25;
                                    } else {
                                        if ((abVar != null ? Integer.valueOf(abVar.f446159j) : null) != null) {
                                            i17 = abVar.f446159j;
                                        }
                                    }
                                    str = strArr2[i17];
                                }
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("Referer", "https://qfile.qq.com"));
                                ImageKt.a(null, null, str4, null, null, iVar, null, i3, null, null, str3, null, null, str, null, null, null, new Function1<LoadFailureParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileThumbnailViewKt$QQFTFileThumbnailView$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LoadFailureParams loadFailureParams) {
                                        LoadFailureParams loadFailureParams2 = loadFailureParams;
                                        objectRef.element.setValue("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_OZLrxvuOrE-.png");
                                        KLog kLog = KLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("image load failure code:");
                                        m3.append(loadFailureParams2.getErrorCode());
                                        m3.append(" msg:");
                                        m3.append(loadFailureParams2.getErrorMsg());
                                        kLog.e("QQFTFileThumbnailView", m3.toString());
                                        return Unit.INSTANCE;
                                    }
                                }, null, null, mutableMapOf, startRestartGroup, ((i16 << 18) & 29360128) | 262144, 0, 8, 908123);
                                if (abVar != null && abVar.f446159j == 2) {
                                    ImageKt.a(null, null, null, null, null, iVar2, null, h.INSTANCE.c(), null, null, "data:image/png;base64,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", null, null, null, null, null, null, null, null, null, null, startRestartGroup, 12845056, 6, 0, 2095967);
                                }
                                startRestartGroup.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                return;
                            }
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileThumbnailViewKt$QQFTFileThumbnailView$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Unit invoke(Composer composer2, Integer num) {
                                    num.intValue();
                                    QQFTFileThumbnailViewKt.m125QQFTFileThumbnailViewCvonfEE(i.this, i3, iVar2, qQFTFileDetailItemVM, composer2, i16 | 1);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                    }
                }
            }
            z17 = true;
            if (z17) {
            }
        }
        z16 = false;
        int i172 = 11;
        if (z16) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
