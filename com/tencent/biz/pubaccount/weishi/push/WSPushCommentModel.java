package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u001aJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/push/WSPushCommentModel;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "<set-?>", "d", "Z", "g", "()Z", WSAutoShowCommentParams.KEY_IS_SHOW_COMMENT_PANEL, "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", WSAutoShowCommentParams.KEY_COMMENT_ID, "f", WSAutoShowCommentParams.KEY_REPLY_ID, "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", h.F, "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSPushCommentModel implements Parcelable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isShowCommentPanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String commentId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String replyId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static Parcelable.Creator<WSPushCommentModel> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/pubaccount/weishi/push/WSPushCommentModel$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/weishi/push/WSPushCommentModel;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/biz/pubaccount/weishi/push/WSPushCommentModel;", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<WSPushCommentModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushCommentModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WSPushCommentModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushCommentModel[] newArray(int size) {
            return new WSPushCommentModel[size];
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u001e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/push/WSPushCommentModel$b;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/biz/pubaccount/weishi/push/WSPushCommentModel;", "a", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.push.WSPushCommentModel$b, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        @JvmStatic
        public final WSPushCommentModel a(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            WSPushCommentModel wSPushCommentModel = new WSPushCommentModel();
            wSPushCommentModel.isShowCommentPanel = jsonObject.optInt(WSAutoShowCommentParams.KEY_IS_SHOW_COMMENT_PANEL) == 1;
            String optString = jsonObject.optString(WSAutoShowCommentParams.KEY_COMMENT_ID);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"commentId\")");
            wSPushCommentModel.commentId = optString;
            String optString2 = jsonObject.optString(WSAutoShowCommentParams.KEY_REPLY_ID);
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"replyId\")");
            wSPushCommentModel.replyId = optString2;
            return wSPushCommentModel;
        }
    }

    public WSPushCommentModel() {
        this.commentId = "";
        this.replyId = "";
    }

    @JvmStatic
    public static final WSPushCommentModel j(JSONObject jSONObject) {
        return INSTANCE.a(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getCommentId() {
        return this.commentId;
    }

    /* renamed from: f, reason: from getter */
    public final String getReplyId() {
        return this.replyId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsShowCommentPanel() {
        return this.isShowCommentPanel;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WSPushCommentModel(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isShowCommentPanel = parcel.readInt() == 1;
        String readString = parcel.readString();
        this.commentId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.replyId = readString2 != null ? readString2 : "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (dest == null) {
            return;
        }
        dest.writeInt(this.isShowCommentPanel ? 1 : 0);
        dest.writeString(this.commentId);
        dest.writeString(this.replyId);
    }
}
