package nm;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$AnyCell;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellAction;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellBottom;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellBotton;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellHeader;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPic;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPlainText;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellTitle;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellVisitor;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$InnerMessage;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001:\b\u0007\f\u0015\u0016\u0017\u0018\u0019\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R>\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lnm/c;", "", "Lnm/b;", "messageBlockData", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$InnerMessage;", "innerMessage", "", "a", "Ljava/util/HashMap;", "", "Lnm/a;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getSTransFormList", "()Ljava/util/HashMap;", "setSTransFormList", "(Ljava/util/HashMap;)V", "sTransFormList", "<init>", "()V", "c", "d", "e", "f", "g", tl.h.F, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f420447a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashMap<Integer, nm.a> sTransFormList;

    static {
        HashMap<Integer, nm.a> hashMap = new HashMap<>();
        sTransFormList = hashMap;
        hashMap.put(11, new d());
        sTransFormList.put(12, new g());
        sTransFormList.put(13, new b());
        sTransFormList.put(14, new h());
        sTransFormList.put(15, new C10851c());
        sTransFormList.put(16, new e());
        sTransFormList.put(17, new a());
        sTransFormList.put(18, new f());
    }

    c() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$a;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class a implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellAction qZoneOfficialAccountBase$CellAction = new QZoneOfficialAccountBase$CellAction();
            try {
                qZoneOfficialAccountBase$CellAction.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellActionTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellAction.has()) {
                blockData.n(qZoneOfficialAccountBase$CellAction);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$b;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class b implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellBottom qZoneOfficialAccountBase$CellBottom = new QZoneOfficialAccountBase$CellBottom();
            try {
                qZoneOfficialAccountBase$CellBottom.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellBottomTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellBottom.has()) {
                blockData.o(qZoneOfficialAccountBase$CellBottom);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$c;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nm.c$c, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    private static final class C10851c implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellBotton qZoneOfficialAccountBase$CellBotton = new QZoneOfficialAccountBase$CellBotton();
            try {
                qZoneOfficialAccountBase$CellBotton.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellButtonTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellBotton.has()) {
                blockData.p(qZoneOfficialAccountBase$CellBotton);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$d;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class d implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellHeader qZoneOfficialAccountBase$CellHeader = new QZoneOfficialAccountBase$CellHeader();
            try {
                qZoneOfficialAccountBase$CellHeader.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellHeaderTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellHeader.has()) {
                blockData.q(qZoneOfficialAccountBase$CellHeader);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$e;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class e implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellPic qZoneOfficialAccountBase$CellPic = new QZoneOfficialAccountBase$CellPic();
            try {
                qZoneOfficialAccountBase$CellPic.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellPicTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellPic.has()) {
                blockData.r(qZoneOfficialAccountBase$CellPic);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$f;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class f implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellPlainText qZoneOfficialAccountBase$CellPlainText = new QZoneOfficialAccountBase$CellPlainText();
            try {
                qZoneOfficialAccountBase$CellPlainText.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellPlainTextTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellPlainText.has()) {
                blockData.s(qZoneOfficialAccountBase$CellPlainText);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$g;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class g implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellTitle qZoneOfficialAccountBase$CellTitle = new QZoneOfficialAccountBase$CellTitle();
            try {
                qZoneOfficialAccountBase$CellTitle.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellTitleTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellTitle.has()) {
                blockData.t(qZoneOfficialAccountBase$CellTitle);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lnm/c$h;", "Lnm/a;", "Lnm/b;", "blockData", "", "data", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    private static final class h implements nm.a {
        @Override // nm.a
        public void a(nm.b blockData, byte[] data) {
            if (blockData == null || data == null) {
                return;
            }
            if (data.length == 0) {
                return;
            }
            QZoneOfficialAccountBase$CellVisitor qZoneOfficialAccountBase$CellVisitor = new QZoneOfficialAccountBase$CellVisitor();
            try {
                qZoneOfficialAccountBase$CellVisitor.mergeFrom(data);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QZoneInnerMessageTransFormHelper", 1, "CellVisitorTransFormer doTransForm error:", e16.toString());
            }
            if (qZoneOfficialAccountBase$CellVisitor.has()) {
                blockData.u(qZoneOfficialAccountBase$CellVisitor);
            }
        }
    }

    public final void a(nm.b messageBlockData, QZoneOfficialAccountBase$InnerMessage innerMessage) {
        if (messageBlockData == null || innerMessage == null) {
            return;
        }
        for (QZoneOfficialAccountBase$AnyCell qZoneOfficialAccountBase$AnyCell : innerMessage.cell_list.get()) {
            nm.a aVar = sTransFormList.get(Integer.valueOf(qZoneOfficialAccountBase$AnyCell.cell_type.get()));
            if (aVar != null) {
                aVar.a(messageBlockData, qZoneOfficialAccountBase$AnyCell.cell_data.get().toByteArray());
            }
        }
    }
}
