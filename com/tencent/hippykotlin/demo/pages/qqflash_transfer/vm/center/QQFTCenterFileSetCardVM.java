package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQFTCenterFileSetCardViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import defpackage.l;
import java.util.List;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import ws3.br;
import ws3.eo;
import ws3.es;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTCenterFileSetCardVM extends BaseComposeCardViewModel {
    public final br fileSet;
    public final MutableState<Integer> fileSetStatus;
    public final MutableState<eo> simpleStatusInfo;

    /* renamed from: vm, reason: collision with root package name */
    public final QQTransferCenterViewModel f114262vm;

    public QQFTCenterFileSetCardVM(QQTransferCenterViewModel qQTransferCenterViewModel, br brVar) {
        MutableState<eo> mutableStateOf$default;
        MutableState<Integer> mutableStateOf$default2;
        this.f114262vm = qQTransferCenterViewModel;
        this.fileSet = brVar;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.simpleStatusInfo = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(brVar.c()), null, 2, null);
        this.fileSetStatus = mutableStateOf$default2;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("init fileSetId:");
        m3.append(brVar.b());
        m3.append(" fileSetStatus:");
        m3.append(brVar.c());
        m3.append(" uploadStatus:");
        m3.append(brVar.d());
        m3.append(" downloadStatus:");
        m3.append(brVar.a());
        kLog.d("QQFTCenterFileSetCardVM", m3.toString());
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(234201029, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(234201029, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM.<anonymous> (QQFTCenterFileSetCardVM.kt:21)");
                }
                QQFTCenterFileSetCardViewKt.QQFTCenterFileSetCardView(QQFTCenterFileSetCardVM.this, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }

    public final int currentFileSetStatus() {
        int intValue = this.fileSetStatus.getValue().intValue();
        if (this.simpleStatusInfo.getValue() == null) {
            return intValue;
        }
        eo value = this.simpleStatusInfo.getValue();
        Intrinsics.checkNotNull(value);
        return value.f446349g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r0.f446199m == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String fromText() {
        Object firstOrNull;
        br brVar = this.fileSet;
        boolean z16 = (brVar == null || brVar.f446192f.isEmpty()) ? false : true;
        if (z16) {
            return "\u6211\u4e0a\u4f20\u7684 \u00b7 ";
        }
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6765\u81ea");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.fileSet.f446192f);
        es esVar = (es) firstOrNull;
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(m3, esVar != null ? esVar.f446362b : null, " \u00b7 ");
    }

    public final boolean shouldAlpha() {
        int currentFileSetStatus = currentFileSetStatus();
        return currentFileSetStatus == 7 || currentFileSetStatus == 4 || currentFileSetStatus == 5;
    }

    public final boolean shouldShowShareButton() {
        int currentFileSetStatus = currentFileSetStatus();
        return (this.fileSet.f446199m != 1 || !this.f114262vm.showTopEmptyCard || currentFileSetStatus == 3 || currentFileSetStatus == 4 || currentFileSetStatus == 5 || currentFileSetStatus == 6 || currentFileSetStatus == 7) ? false : true;
    }

    public final Triple<String, String, String> statusData() {
        String valueOf;
        String str;
        String valueOf2;
        String str2;
        int compare;
        String str3 = "\u5df2\u4e0b\u8f7d";
        String str4 = "";
        if (this.simpleStatusInfo.getValue() != null) {
            eo value = this.simpleStatusInfo.getValue();
            Intrinsics.checkNotNull(value);
            eo eoVar = value;
            int i3 = eoVar.f446348f;
            String fromText = fromText();
            if (i3 == 13) {
                str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                str3 = "\u5df2\u8fc7\u671f";
            } else if (i3 == 14) {
                str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                str3 = "\u5df2\u5220\u9664";
            } else if (i3 == 12 || i3 == 15) {
                str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                str3 = "\u5df2\u5931\u6548";
            } else if (i3 == 8) {
                str3 = "\u6682\u505c\u4e0b\u8f7d";
            } else if (i3 == 11) {
                compare = Long.compare(eoVar.f446344b ^ Long.MIN_VALUE, eoVar.f446346d ^ Long.MIN_VALUE);
                if (compare < 0) {
                    str4 = QUIToken.INSTANCE.image("arrow_down_circle_dotted_new", QUIToken.color$default("icon_tertiary"));
                    str3 = "\u90e8\u5206\u5df2\u4e0b\u8f7d";
                } else {
                    str4 = QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success"));
                }
            } else if (i3 == 9) {
                str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                if (this.fileSet.f446189c == 1) {
                    str3 = "\u4e0b\u8f7d\u5931\u8d25";
                } else {
                    str3 = ((Object) UInt.m615toStringimpl(this.fileSet.f446198l.f446403c)) + "\u4e2a\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25";
                }
            } else {
                if (i3 == 3) {
                    br brVar = this.fileSet;
                    if (brVar != null && brVar.f446199m == 1 && brVar.f446200n) {
                        str3 = "\u6682\u505c\u4e0a\u4f20";
                    }
                }
                if (i3 == 4) {
                    br brVar2 = this.fileSet;
                    if (brVar2 != null && brVar2.f446199m == 1 && brVar2.f446200n) {
                        str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                        if (this.fileSet.f446189c == 1) {
                            str3 = "\u4e0a\u4f20\u5931\u8d25";
                        } else {
                            str3 = ((Object) UInt.m615toStringimpl(this.fileSet.f446197k.f446360b)) + "\u4e2a\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25";
                        }
                    }
                }
                if (i3 != 1 && i3 != 7) {
                    StringBuilder sb5 = new StringBuilder();
                    int i16 = this.fileSet.f446193g;
                    if (i16 > 86400) {
                        valueOf2 = String.valueOf(((i16 / 3600) / 24) + 1);
                    } else if (i16 >= 3600) {
                        valueOf2 = String.valueOf((i16 / 3600) + 1);
                    } else {
                        valueOf2 = String.valueOf((i16 / 60) + 1);
                    }
                    sb5.append(valueOf2);
                    int i17 = this.fileSet.f446193g;
                    if (i17 > 86400) {
                        str2 = "\u5929";
                    } else if (i17 >= 3600) {
                        str2 = "\u5c0f\u65f6";
                    } else {
                        str2 = "\u5206\u949f";
                    }
                    str3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, str2, "\u540e\u8fc7\u671f");
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    l lVar = l.f413536a;
                    eo value2 = this.simpleStatusInfo.getValue();
                    sb6.append(lVar.b(value2 != null ? value2.f446345c : 0L));
                    eo value3 = this.simpleStatusInfo.getValue();
                    sb6.append(lVar.c(value3 != null ? value3.f446345c : 0L));
                    sb6.append('/');
                    eo value4 = this.simpleStatusInfo.getValue();
                    sb6.append(lVar.b(value4 != null ? value4.f446347e : 0L));
                    eo value5 = this.simpleStatusInfo.getValue();
                    sb6.append(lVar.c(value5 != null ? value5.f446347e : 0L));
                    fromText = sb6.toString();
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u00b7\u9884\u8ba1");
                    eo value6 = this.simpleStatusInfo.getValue();
                    m3.append(lVar.a(value6 != null ? value6.f446353k : 0L));
                    str3 = m3.toString();
                }
            }
            return new Triple<>(fromText, str4, str3);
        }
        br brVar3 = this.fileSet;
        int i18 = brVar3.f446203q;
        int i19 = brVar3.f446202p;
        int i26 = brVar3.f446201o;
        String fromText2 = fromText();
        if (i26 == 5) {
            str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
            str3 = "\u5df2\u8fc7\u671f";
        } else if (i26 == 7) {
            str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
            str3 = "\u5df2\u5220\u9664";
        } else if (i26 == 4 || i26 == 6) {
            str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
            str3 = "\u5df2\u5931\u6548";
        } else if (i18 == 5) {
            str3 = "\u6682\u505c\u4e0b\u8f7d";
        } else if (i18 == 4) {
            str4 = QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success"));
        } else if (i18 == 3) {
            str4 = QUIToken.INSTANCE.image("arrow_down_circle_dotted_new", QUIToken.color$default("icon_tertiary"));
            str3 = "\u90e8\u5206\u5df2\u4e0b\u8f7d";
        } else if (i18 == 6) {
            str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
            if (this.fileSet.f446189c == 1) {
                str3 = "\u4e0b\u8f7d\u5931\u8d25";
            } else {
                str3 = ((Object) UInt.m615toStringimpl(this.fileSet.f446198l.f446403c)) + "\u4e2a\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25";
            }
        } else {
            if (i19 == 5) {
                br brVar4 = this.fileSet;
                if (brVar4 != null && brVar4.f446199m == 1 && brVar4.f446200n) {
                    str3 = "\u6682\u505c\u4e0a\u4f20";
                }
            }
            if (i19 == 6) {
                br brVar5 = this.fileSet;
                if (brVar5 != null && brVar5.f446199m == 1 && brVar5.f446200n) {
                    str4 = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                    if (this.fileSet.f446189c == 1) {
                        str3 = "\u4e0a\u4f20\u5931\u8d25";
                    } else {
                        str3 = ((Object) UInt.m615toStringimpl(this.fileSet.f446197k.f446360b)) + "\u4e2a\u6587\u4ef6\u4e0a\u4f20\u5931\u8d25";
                    }
                }
            }
            StringBuilder sb7 = new StringBuilder();
            int i27 = this.fileSet.f446193g;
            if (i27 > 86400) {
                valueOf = String.valueOf(((i27 / 3600) / 24) + 1);
            } else if (i27 >= 3600) {
                valueOf = String.valueOf((i27 / 3600) + 1);
            } else {
                valueOf = String.valueOf((i27 / 60) + 1);
            }
            sb7.append(valueOf);
            int i28 = this.fileSet.f446193g;
            if (i28 > 86400) {
                str = "\u5929";
            } else if (i28 >= 3600) {
                str = "\u5c0f\u65f6";
            } else {
                str = "\u5206\u949f";
            }
            str3 = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb7, str, "\u540e\u8fc7\u671f");
        }
        return new Triple<>(fromText2, str4, str3);
    }
}
