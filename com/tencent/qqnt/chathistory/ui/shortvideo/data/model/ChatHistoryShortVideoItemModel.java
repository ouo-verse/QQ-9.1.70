package com.tencent.qqnt.chathistory.ui.shortvideo.data.model;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0018\b\u0080\b\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001e4B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\b\u0018\u00010\u0004R\u00020\u0000H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0018\u00010\u0004R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010$\u001a\u00020\u001d8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0011\u0010&\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010+\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010(R\u0013\u0010-\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010(R\u0013\u0010/\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010(R\u0013\u00101\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010(\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "", "Lcom/tencent/qqnt/chathistory/ui/base/i;", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a$b;", "j", "", "p", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", h.F, "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getElement", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "f", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a$b;", "shortVideoArkInfo", "", "a", "()J", "msgTime", "g", "msgId", "i", "msgSeq", "()I", "chatType", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "shortVideoNickName", "k", "shortVideoAvatar", "l", "shortVideoCover", "o", "shortVideoTitle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "shortVideoJump", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)V", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.chathistory.ui.shortvideo.data.model.a, reason: from toString */
/* loaded from: classes23.dex */
public final /* data */ class ChatHistoryShortVideoItemModel extends com.tencent.qqnt.chathistory.ui.base.item.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MsgElement element;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b shortVideoArkInfo;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0019\u0010\b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a$b;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "view", "b", "getBizsrc", h.F, QQCustomArkDialogUtil.BIZ_SRC, "c", "g", "avatar", "d", "j", "nickname", "e", "k", "preview", "l", "title", "i", "jumpURL", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.shortvideo.data.model.a$b */
    /* loaded from: classes23.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String view = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String bizsrc = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String avatar = "";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String nickname = "";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String preview = "";

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String title = "";

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String jumpURL = "";

        public b() {
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAvatar() {
            return this.avatar;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getJumpURL() {
            return this.jumpURL;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNickname() {
            return this.nickname;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getPreview() {
            return this.preview;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getView() {
            return this.view;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatar = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bizsrc = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpURL = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nickname = str;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.preview = str;
        }

        public final void l(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void m(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.view = str;
        }
    }

    public ChatHistoryShortVideoItemModel(@NotNull MsgRecord msgRecord, @NotNull MsgElement element) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(element, "element");
        this.msgRecord = msgRecord;
        this.element = element;
        this.shortVideoArkInfo = j();
    }

    private final b j() {
        Object obj;
        String str;
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z16;
        ArkElement arkElement;
        ArrayList<MsgElement> arrayList = this.msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MsgElement msgElement = (MsgElement) next;
            if (msgElement == null || msgElement.elementType != 10) {
                z17 = false;
            }
            if (z17) {
                arrayList2.add(next);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                MsgElement msgElement2 = (MsgElement) obj;
                if (msgElement2 != null && (arkElement = msgElement2.arkElement) != null) {
                    str7 = arkElement.bytesData;
                } else {
                    str7 = null;
                }
                if (str7 != null && str7.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement3 = (MsgElement) obj;
        if (msgElement3 == null) {
            return null;
        }
        try {
            ArkElement arkElement2 = msgElement3.arkElement;
            if (arkElement2 != null) {
                str = arkElement2.bytesData;
            } else {
                str = null;
            }
            JSONObject jSONObject2 = new JSONObject(str);
            b bVar = new b();
            String string = jSONObject2.getString("view");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(KEY_VIEW)");
            bVar.m(string);
            String string2 = jSONObject2.getString(QQCustomArkDialogUtil.BIZ_SRC);
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(KEY_BIZ_SRC)");
            bVar.h(string2);
            JSONObject jSONObject3 = jSONObject2.getJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (jSONObject3 == null || (jSONObject = jSONObject3.getJSONObject("video")) == null) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                str2 = jSONObject.getString("avatar");
            } else {
                str2 = null;
            }
            String str8 = "";
            if (str2 == null) {
                str2 = "";
            }
            bVar.g(str2);
            if (jSONObject != null) {
                str3 = jSONObject.getString("nickname");
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            bVar.j(str3);
            if (jSONObject != null) {
                str4 = jSONObject.getString("preview");
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = "";
            }
            bVar.k(str4);
            if (jSONObject != null) {
                str5 = jSONObject.getString("jumpURL");
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str5 = "";
            }
            bVar.i(str5);
            if (jSONObject != null) {
                str6 = jSONObject.getString("title");
            } else {
                str6 = null;
            }
            if (str6 != null) {
                str8 = str6;
            }
            bVar.l(str8);
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a */
    public long getMsgTime() {
        return this.msgRecord.msgTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatHistoryShortVideoItemModel)) {
            return false;
        }
        ChatHistoryShortVideoItemModel chatHistoryShortVideoItemModel = (ChatHistoryShortVideoItemModel) other;
        if (Intrinsics.areEqual(this.msgRecord, chatHistoryShortVideoItemModel.msgRecord) && Intrinsics.areEqual(this.element, chatHistoryShortVideoItemModel.element)) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.msgRecord.chatType;
    }

    public long g() {
        return this.msgRecord.msgId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    public int hashCode() {
        return (this.msgRecord.hashCode() * 31) + this.element.hashCode();
    }

    public final long i() {
        return this.msgRecord.msgSeq;
    }

    @Nullable
    public final String k() {
        b bVar = this.shortVideoArkInfo;
        if (bVar != null) {
            return bVar.getAvatar();
        }
        return null;
    }

    @Nullable
    public final String l() {
        b bVar = this.shortVideoArkInfo;
        if (bVar != null) {
            return bVar.getPreview();
        }
        return null;
    }

    @Nullable
    public final String m() {
        b bVar = this.shortVideoArkInfo;
        if (bVar != null) {
            return bVar.getJumpURL();
        }
        return null;
    }

    @Nullable
    public final String n() {
        b bVar = this.shortVideoArkInfo;
        if (bVar != null) {
            return bVar.getNickname();
        }
        return null;
    }

    @Nullable
    public final String o() {
        b bVar = this.shortVideoArkInfo;
        if (bVar != null) {
            return bVar.getTitle();
        }
        return null;
    }

    public final boolean p() {
        String str;
        if (this.msgRecord.msgType == 11 && this.element.elementType == 10) {
            b j3 = j();
            if (j3 != null) {
                str = j3.getView();
            } else {
                str = null;
            }
            return Intrinsics.areEqual(str, "video");
        }
        return false;
    }

    @NotNull
    public String toString() {
        return "ChatHistoryShortVideoItemModel(msgRecord=" + this.msgRecord + ", element=" + this.element + ")";
    }
}
