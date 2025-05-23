package com.tencent.hippykotlin.demo.pages.qqflash_transfer.utils;

import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import defpackage.k;
import kotlin.ULong;
import ws3.ab;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTReportUtil {
    public static final QQFTReportUtil INSTANCE = new QQFTReportUtil();

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a1, code lost:
    
        if ((r10.f446172w.length() == 0) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d4, code lost:
    
        if (r1 < 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f7, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
    
        if (r10 != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e4, code lost:
    
        if (r1 < 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f5, code lost:
    
        if (r10 < 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c4, code lost:
    
        if (r1 < 0) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e getDetailItemParams(QQFlashTransferViewModel qQFlashTransferViewModel, ab abVar) {
        String str;
        int compare;
        int compare2;
        int compare3;
        int compare4;
        e qQFTDTBaseParam = getQQFTDTBaseParam();
        qQFTDTBaseParam.v("filetype", String.valueOf(abVar != null ? Integer.valueOf(abVar.f446159j) : null));
        qQFTDTBaseParam.v(MediaDBValues.FILESIZE, String.valueOf(abVar != null ? ULong.m642boximpl(abVar.f446164o) : null));
        qQFTDTBaseParam.v("file_status", String.valueOf(abVar != null ? Integer.valueOf(abVar.A) : null));
        String str2 = "1";
        if (qQFlashTransferViewModel.isGridMode.getValue().booleanValue()) {
            str = "1";
        } else {
            str = "2";
        }
        qQFTDTBaseParam.v("current_mode", str);
        qQFTDTBaseParam.v("upload_status", String.valueOf(abVar != null ? Integer.valueOf(abVar.B) : null));
        qQFTDTBaseParam.v("download_status", String.valueOf(abVar != null ? Integer.valueOf(abVar.C) : null));
        boolean z16 = false;
        if (abVar != null) {
            if (abVar.f446152c.length() > 0) {
            }
            int i3 = abVar.f446159j;
            if (i3 != 26 && i3 != 2 && i3 != 4) {
                if (i3 == 3 || i3 == 10 || i3 == 13) {
                    compare = Long.compare(abVar.f446164o ^ Long.MIN_VALUE, QQFTReportUtilKt.DocFilePreviewMaxSize ^ Long.MIN_VALUE);
                }
                if (abVar.f446159j == 6) {
                    compare4 = Long.compare(abVar.f446164o ^ Long.MIN_VALUE, QQFTReportUtilKt.XlsFilePreviewMaxSize ^ Long.MIN_VALUE);
                }
                if (abVar.f446159j == 7) {
                    compare3 = Long.compare(abVar.f446164o ^ Long.MIN_VALUE, QQFTReportUtilKt.PptFilePreviewMaxSize ^ Long.MIN_VALUE);
                }
                if (abVar.f446159j == 9) {
                    compare2 = Long.compare(abVar.f446164o ^ Long.MIN_VALUE, QQFTReportUtilKt.PdfFilePreviewMaxSize ^ Long.MIN_VALUE);
                }
                boolean z17 = false;
            }
            z16 = true;
        }
        if (!z16) {
            str2 = "0";
        }
        qQFTDTBaseParam.v("can_online_preview", str2);
        return qQFTDTBaseParam;
    }

    public final e getQQFTDTBaseParam() {
        String str;
        if (k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        return DTReportConstKt.getDTBaseParams(str);
    }
}
