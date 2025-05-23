package kk;

import android.view.View;
import com.qzone.reborn.base.l;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mk.h;
import qj.i;
import qzone.QZIntimateSpaceReader$CommreaderSpaceAbs;
import yo.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J \u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0010"}, d2 = {"Lkk/a;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/message/data/a;", "", "y", "w", HippyTKDListViewAdapter.X, "Landroid/view/View;", "elementView", "", "elementId", "", "hasSpaceInfo", "u", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a extends l<com.qzone.reborn.message.data.a> {
    /* JADX WARN: Multi-variable type inference failed */
    public final void u(View elementView, String elementId, boolean hasSpaceInfo) {
        QZIntimateSpaceReader$CommreaderSpaceAbs qZIntimateSpaceReader$CommreaderSpaceAbs;
        Intrinsics.checkNotNullParameter(elementView, "elementView");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        HashMap hashMap = new HashMap();
        if (hasSpaceInfo && (qZIntimateSpaceReader$CommreaderSpaceAbs = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().spaceinfo.get()) != null) {
            hashMap.put("close_friend_space_type", Integer.valueOf(qZIntimateSpaceReader$CommreaderSpaceAbs.space_type.get()));
            String str = qZIntimateSpaceReader$CommreaderSpaceAbs.space_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.space_id.get()");
            hashMap.put("close_friend_space_id", str);
        }
        String str2 = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().op_user.uid.get();
        Intrinsics.checkNotNullExpressionValue(str2, "mData.stNotice.op_user.uid.get()");
        hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str2);
        hashMap.put("touin", Long.valueOf(h.f416877a.f(((com.qzone.reborn.message.data.a) this.mData).getStNotice().op_user.uid.get(), ((com.qzone.reborn.message.data.a) this.mData).getStCommonExt())));
        fo.c.o(elementView, elementId, new fo.b().l(hashMap).i(((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_id.get()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w() {
        i iVar = (i) q(i.class);
        if (iVar != null) {
            iVar.i3((com.qzone.reborn.message.data.a) this.mData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        qj.h hVar = (qj.h) q(qj.h.class);
        if (hVar != null) {
            hVar.J5((com.qzone.reborn.message.data.a) this.mData, this.mPosition);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        if (((com.qzone.reborn.message.data.a) this.mData).getStNotice().space_button != null) {
            String str = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().space_button.actionurl.get();
            if (str == null || str.length() == 0) {
                return;
            }
            yo.d.b(p(), new g(((com.qzone.reborn.message.data.a) this.mData).getStNotice().space_button.actionurl.get()));
        }
    }

    public static /* synthetic */ void v(a aVar, View view, String str, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            aVar.u(view, str, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dtReportButton");
    }
}
