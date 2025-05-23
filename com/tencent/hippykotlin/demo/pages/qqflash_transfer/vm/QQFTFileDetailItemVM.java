package com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTBlankItemViewKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTFileItemViewKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import java.util.List;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import ws3.ab;
import ws3.br;
import ws3.cd;
import ws3.eg;
import ws3.eq;
import ws3.k;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTFileDetailItemVM extends QQFTCardVM {
    public MutableState<Integer> compressStatus;
    public MutableState<Integer> downloadStatus;
    public ab fileDetail;
    public MutableState<Integer> fileStatus;
    public boolean isFromCache;
    public MutableState<Boolean> isSelected;
    public MutableState<String> thumbnailUrl;
    public MutableState<Float> uploadProcess;
    public MutableState<Integer> uploadStatus;

    public QQFTFileDetailItemVM(final QQFlashTransferViewModel qQFlashTransferViewModel, ab abVar, final boolean z16) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Integer> mutableStateOf$default2;
        MutableState<Integer> mutableStateOf$default3;
        MutableState<Integer> mutableStateOf$default4;
        MutableState<Float> mutableStateOf$default5;
        MutableState<Integer> mutableStateOf$default6;
        MutableState<String> mutableStateOf$default7;
        k a16;
        this.fileDetail = abVar;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.isSelected = mutableStateOf$default;
        ab abVar2 = this.fileDetail;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(abVar2 != null ? abVar2.c() : 0), null, 2, null);
        this.fileStatus = mutableStateOf$default2;
        ab abVar3 = this.fileDetail;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(abVar3 != null ? abVar3.d() : 0), null, 2, null);
        this.uploadStatus = mutableStateOf$default3;
        ab abVar4 = this.fileDetail;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(abVar4 != null ? abVar4.b() : 0), null, 2, null);
        this.downloadStatus = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.uploadProcess = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.compressStatus = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.thumbnailUrl = mutableStateOf$default7;
        ab abVar5 = this.fileDetail;
        if (abVar5 != null && (a16 = abVar5.a()) != null) {
            this.compressStatus.setValue(Integer.valueOf(a16.a()));
        }
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(1746238314, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                int intValue = num.intValue();
                Composer composer2 = composer;
                int intValue2 = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1746238314, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.QQFTFileDetailItemVM.<anonymous> (QQFTFileDetailItemVM.kt:72)");
                }
                if (z16) {
                    composer2.startReplaceableGroup(-1066948340);
                    QQFTBlankItemViewKt.QQFTBlankItemView(this, composer2, 0);
                    composer2.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-1066948258);
                    QQFTFileItemViewKt.QQFTFileItemView(intValue, qQFlashTransferViewModel, this, composer2, ((intValue2 >> 6) & 14) | 64);
                    composer2.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }

    public final String getFileName() {
        String str;
        String str2;
        String str3;
        if (this.fileStatus.getValue().intValue() != 4) {
            ab abVar = this.fileDetail;
            boolean z16 = false;
            if (abVar != null && (str3 = abVar.f446160k) != null) {
                if (str3.length() == 0) {
                    z16 = true;
                }
            }
            if (!z16) {
                String str4 = null;
                if (this.fileStatus.getValue().intValue() == 5) {
                    StringBuilder sb5 = new StringBuilder();
                    ab abVar2 = this.fileDetail;
                    sb5.append((abVar2 == null || (str2 = abVar2.f446160k) == null) ? null : StringsKt__StringsKt.substringAfterLast(str2, '.', ""));
                    sb5.append("\u6587\u4ef6.");
                    ab abVar3 = this.fileDetail;
                    if (abVar3 != null && (str = abVar3.f446160k) != null) {
                        str4 = StringsKt__StringsKt.substringAfterLast(str, '.', "");
                    }
                    sb5.append(str4);
                    return sb5.toString();
                }
                ab abVar4 = this.fileDetail;
                if (abVar4 != null) {
                    return abVar4.f446160k;
                }
                return null;
            }
        }
        return "\u6587\u4ef6\u52a0\u8f7d\u4e2d";
    }

    public final boolean shouldShowFileStatus() {
        ab abVar = this.fileDetail;
        if (abVar != null && abVar.f446155f) {
            UInt m564boximpl = abVar != null ? UInt.m564boximpl(abVar.f446165p) : null;
            if (m564boximpl != null && m564boximpl.getData() == 0) {
                ab abVar2 = this.fileDetail;
                ULong m642boximpl = abVar2 != null ? ULong.m642boximpl(abVar2.f446164o) : null;
                if (m642boximpl != null && m642boximpl.getData() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0178, code lost:
    
        if (r15.filterType.getValue() == com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.FTFilterType.NOT_DOWNLOAD_FILE) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:
    
        if (r15.filterType.getValue() != com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.FTFilterType.DOWNLOADED_FILE) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f0, code lost:
    
        if (r15.filterType.getValue() == com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.FTFilterType.NOT_DOWNLOAD_FILE) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x017e, code lost:
    
        r15 = r0;
        r0 = "\u90e8\u5206\u5df2\u4e0b\u8f7d";
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017a, code lost:
    
        r15 = r0;
        r0 = "\u90e8\u5206\u672a\u4e0b\u8f7d";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Triple<String, String, Boolean> statusIconAndText(QQFlashTransferViewModel qQFlashTransferViewModel) {
        String image;
        String str;
        String str2;
        String image2;
        int compare;
        cd cdVar;
        boolean z16 = false;
        if (this.fileStatus.getValue().intValue() == 3) {
            image = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
            str = "\u5df2\u8fc7\u671f";
        } else {
            if (this.downloadStatus.getValue().intValue() == 3) {
                image = QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success"));
            } else {
                if (this.downloadStatus.getValue().intValue() != 5) {
                    if (this.compressStatus.getValue().intValue() == 6) {
                        ab abVar = this.fileDetail;
                        if (abVar != null && abVar.f446159j == 4) {
                        }
                    }
                    if (this.downloadStatus.getValue().intValue() != 1 && this.downloadStatus.getValue().intValue() != 4 && this.downloadStatus.getValue().intValue() != 2) {
                        if (this.uploadStatus.getValue().intValue() != 1 && this.uploadStatus.getValue().intValue() != 4 && this.uploadStatus.getValue().intValue() != 2 && this.fileStatus.getValue().intValue() != 4) {
                            if (this.uploadStatus.getValue().intValue() != 5 && this.uploadStatus.getValue().intValue() != 6) {
                                if (this.compressStatus.getValue().intValue() == 4) {
                                    ab abVar2 = this.fileDetail;
                                    if (abVar2 != null && abVar2.f446159j == 4) {
                                        image = QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success"));
                                    }
                                }
                                if (this.compressStatus.getValue().intValue() == 3 || this.compressStatus.getValue().intValue() == 6) {
                                    ab abVar3 = this.fileDetail;
                                    if (abVar3 != null && abVar3.f446159j == 4) {
                                        image2 = QUIToken.INSTANCE.image("arrow_down_part_circle_dotted", QUIToken.color$default("icon_secondary"));
                                    }
                                }
                                ab abVar4 = this.fileDetail;
                                if ((abVar4 != null && abVar4.f446155f) && (this.downloadStatus.getValue().intValue() == 0 || this.downloadStatus.getValue().intValue() == 6 || this.downloadStatus.getValue().intValue() == 7)) {
                                    ab abVar5 = this.fileDetail;
                                    UInt uInt = null;
                                    if ((abVar5 != null ? abVar5.E : null) != null) {
                                        if (abVar5 != null && (cdVar = abVar5.E) != null) {
                                            uInt = UInt.m564boximpl(cdVar.f446244d);
                                        }
                                        Intrinsics.checkNotNull(uInt);
                                        compare = Integer.compare(uInt.getData() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
                                        if (compare > 0) {
                                            image2 = QUIToken.INSTANCE.image("arrow_down_part_circle_dotted", QUIToken.color$default("icon_secondary"));
                                        }
                                    }
                                }
                                if (this.downloadStatus.getValue().intValue() != 0 && this.downloadStatus.getValue().intValue() != 6) {
                                    image = "";
                                    str = image;
                                } else {
                                    br value = qQFlashTransferViewModel.fileSet.getValue();
                                    if (value != null && value.f446200n) {
                                        br value2 = qQFlashTransferViewModel.fileSet.getValue();
                                        if (value2 != null && value2.f446199m == 1) {
                                            image = QUIToken.INSTANCE.image("tick", QUIToken.color$default("feedback_success"));
                                            str = "\u4e0a\u4f20\u5b8c\u6210";
                                        }
                                    }
                                    image = QUIToken.INSTANCE.image("arrow_down_circle_dotted_new", QUIToken.color$default("icon_secondary"));
                                    str = "\u672a\u4e0b\u8f7d";
                                }
                            } else {
                                image = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                                str = "\u4e0a\u4f20\u5931\u8d25";
                            }
                        } else if (this.uploadStatus.getValue().intValue() == 2) {
                            str2 = "\u4e0a\u4f20\u4e2d";
                        } else if (this.uploadStatus.getValue().intValue() == 4) {
                            str2 = "\u4e0a\u4f20\u6682\u505c";
                        } else {
                            if (this.fileStatus.getValue().intValue() == 4) {
                                br value3 = qQFlashTransferViewModel.fileSet.getValue();
                                if (value3 != null && value3.f446199m == 1 && value3.f446200n) {
                                    z16 = true;
                                }
                                if (!z16) {
                                    str2 = "\u5ba1\u6838\u4e2d";
                                }
                            }
                            str2 = "\u7b49\u5f85\u4e0a\u4f20";
                        }
                    } else if (this.downloadStatus.getValue().intValue() == 2) {
                        str2 = "\u4e0b\u8f7d\u4e2d";
                    } else if (this.downloadStatus.getValue().intValue() == 4) {
                        str2 = "\u5df2\u6682\u505c";
                    } else {
                        str2 = "\u5f85\u4e0b\u8f7d";
                    }
                    str = str2;
                    z16 = true;
                    image = "";
                }
                image = QUIToken.INSTANCE.image("caution_circle", QUIToken.color$default("feedback_error"));
                str = "\u4e0b\u8f7d\u5931\u8d25";
            }
            str = "\u5df2\u4e0b\u8f7d";
        }
        return new Triple<>(image, str, Boolean.valueOf(z16));
    }

    public final void updateFile(ab abVar) {
        this.fileDetail = abVar;
        updateThumbnailUrl(abVar.f446166q);
        this.fileStatus.setValue(Integer.valueOf(abVar.A));
        this.uploadStatus.setValue(Integer.valueOf(abVar.B));
        this.downloadStatus.setValue(Integer.valueOf(abVar.C));
        this.compressStatus.setValue(Integer.valueOf(abVar.H.f446377a));
    }

    public final void updateThumbnailUrl(eg egVar) {
        int i3;
        List<eq> list;
        eq eqVar;
        String str;
        int size;
        if ((egVar != null ? egVar.f446333b : null) != null && (!egVar.f446333b.isEmpty()) && 1 <= (size = egVar.f446333b.size())) {
            int i16 = 1;
            while (true) {
                i3 = i16 - 1;
                if (!(egVar.f446333b.get(i3).f446358b.length() > 0)) {
                    if (i16 == size) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    break;
                }
            }
        }
        i3 = -1;
        String str2 = "";
        if (i3 < 0) {
            this.thumbnailUrl.setValue("");
            return;
        }
        MutableState<String> mutableState = this.thumbnailUrl;
        if (egVar != null && (list = egVar.f446333b) != null && (eqVar = list.get(i3)) != null && (str = eqVar.f446358b) != null) {
            str2 = str;
        }
        mutableState.setValue(str2);
    }
}
