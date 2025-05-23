package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.richmedia.depend.RichMediaDownloadType;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0013H\u0014R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/file/data/m;", "Lcom/tencent/mobileqq/richmedia/depend/d;", "Lcom/tencent/mobileqq/app/c;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "v", "Lcom/tencent/mobileqq/troop/data/t;", "data", "u", "", "mediaId", "Lcom/tencent/mobileqq/richmedia/depend/RichMediaDownloadType;", "type", "L1", "cancelDownload", ICustomDataEditor.STRING_PARAM_8, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "C0", "", "g", "d", "Lcom/tencent/mobileqq/troop/data/t;", "info", "e", "Ljava/lang/String;", "curMediaId", "f", "Lcom/tencent/mobileqq/richmedia/depend/RichMediaDownloadType;", "curDownloadType", "Lcom/tencent/mobileqq/richmedia/depend/b;", "t", "()Lcom/tencent/mobileqq/richmedia/depend/b;", "callback", "<init>", "(Lcom/tencent/mobileqq/troop/data/t;)V", tl.h.F, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m extends com.tencent.mobileqq.app.c implements com.tencent.mobileqq.richmedia.depend.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final t info;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String curMediaId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RichMediaDownloadType curDownloadType;

    public m(t info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.info = info;
        TroopUtils.f().addObserver(this);
        this.curMediaId = "";
        this.curDownloadType = RichMediaDownloadType.TYPE_ORIGINAL_IMAGE;
    }

    private final com.tencent.mobileqq.richmedia.depend.b t() {
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.b.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IMediaDownloadCallBack::class.java.name");
        com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.mobileqq.richmedia.depend.IMediaDownloadCallBack");
        return (com.tencent.mobileqq.richmedia.depend.b) d16;
    }

    private final void u(t data) {
        if (data.f294972f == 11) {
            QLog.i("TroopFile.TroopFileMediaDownloadDepend", 1, "notifyMediaResult suc, " + data.f294987u + ", mediaId:" + this.curMediaId + ", type:" + this.curDownloadType);
            t().I7(this.curMediaId, true, data.f294978l, this.curDownloadType);
        }
    }

    private final void v(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putLong("TRANS_PARAM_NT_MSGID", this.info.J);
        bundle.putLong("TRANS_PARAM_NT_ELEMENTID", this.info.K);
        bundle.putLong("TRANS_PARAM_UPLOAD_TIME", this.info.f294975i);
        TroopFileItemOperation troopFileItemOperation = new TroopFileItemOperation(this.info.f294971e, TroopUtils.f(), activity);
        t tVar = this.info;
        int i3 = tVar.f294972f;
        if (i3 != 10 && i3 != 9) {
            troopFileItemOperation.C(tVar.f294985s, tVar.f294987u, tVar.f294976j, tVar.f294988v, bundle, null);
        } else {
            troopFileItemOperation.w(tVar.f294967a, bundle, null);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void C0(String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void L1(String mediaId, RichMediaDownloadType type, Activity activity) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(type, "type");
        QLog.i("TroopFile.TroopFileMediaDownloadDepend", 1, "downloadMedia mediaId:" + mediaId + ", type:" + type + ", " + this.info.f294985s + ", " + this.info.f294972f + ", " + activity);
        this.curMediaId = mediaId;
        this.curDownloadType = type;
        if (activity != null) {
            v(activity);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void cancelDownload(String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        if (QLog.isDebugVersion()) {
            QLog.d("TroopFile.TroopFileMediaDownloadDepend", 4, "cancelDownload mediaId:" + mediaId);
        }
    }

    @Override // com.tencent.mobileqq.app.c
    protected void g(Object data) {
        if (data instanceof t) {
            if (QLog.isDebugVersion()) {
                t tVar = (t) data;
                QLog.d("TroopFile.TroopFileMediaDownloadDepend", 4, "onTroopFileStatusUpdate " + tVar.f294985s + ", " + tVar.f294972f);
            }
            t tVar2 = this.info;
            t tVar3 = (t) data;
            if (tVar2.f294971e == tVar3.f294971e && Intrinsics.areEqual(tVar2.f294985s, tVar3.f294985s)) {
                u(tVar3);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void onDestroy() {
        TroopUtils.f().removeObserver(this);
    }

    @Override // com.tencent.mobileqq.richmedia.depend.d
    public void s8(String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
    }
}
