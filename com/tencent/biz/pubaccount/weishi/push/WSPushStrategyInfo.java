package com.tencent.biz.pubaccount.weishi.push;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class WSPushStrategyInfo extends b implements IWSPushStrategy {
    public static final Parcelable.Creator<WSPushStrategyInfo> CREATOR = new a();
    public String mScheme;
    public WSPushCommentModel mWSPushCommentModel;
    public WSPushGloryKingModel mWSPushGloryKingModel;
    public WSPushOpModel mWSPushModel;
    public WSPushOpDialogModel mWSPushOpDialogModel;
    public WSPushPreloadModel mWSPushPreloadModel;
    public WSPushVideoModel mWSPushVideoModel;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<WSPushStrategyInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WSPushStrategyInfo createFromParcel(Parcel parcel) {
            return new WSPushStrategyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WSPushStrategyInfo[] newArray(int i3) {
            return new WSPushStrategyInfo[i3];
        }
    }

    WSPushStrategyInfo(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy
    public String getAbTest() {
        return this.mAbTest;
    }

    public String getScheme() {
        return this.mScheme;
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy
    public int getType() {
        return this.mType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.push.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        this.mScheme = jSONObject.optString(ZPlanPublishSource.FROM_SCHEME);
        this.mWSPushOpDialogModel = WSPushOpDialogModel.parseJson(jSONObject.optJSONObject("op_dialog"));
        this.mWSPushModel = WSPushOpModel.a(jSONObject.optJSONObject("op_content"));
        this.mWSPushPreloadModel = WSPushPreloadModel.a(jSONObject.optJSONObject("preload"));
        this.mWSPushGloryKingModel = WSPushGloryKingModel.a(jSONObject.optJSONObject("material_info"));
        this.mWSPushVideoModel = WSPushVideoModel.b(jSONObject.optJSONObject("video_abstract"));
        this.mWSPushCommentModel = WSPushCommentModel.j(jSONObject.optJSONObject("comment"));
    }

    public String toString() {
        return "WSPushStrategyInfo{mScheme='" + this.mScheme + "', mType=" + this.mType + ", mAbTest='" + this.mAbTest + "'}";
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.b, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.mScheme);
        parcel.writeParcelable(this.mWSPushOpDialogModel, i3);
        parcel.writeParcelable(this.mWSPushModel, i3);
        parcel.writeParcelable(this.mWSPushGloryKingModel, i3);
        parcel.writeParcelable(this.mWSPushVideoModel, i3);
        parcel.writeParcelable(this.mWSPushCommentModel, i3);
    }

    protected WSPushStrategyInfo(Parcel parcel) {
        super(parcel);
        this.mScheme = parcel.readString();
        this.mWSPushOpDialogModel = (WSPushOpDialogModel) parcel.readParcelable(WSPushOpDialogModel.class.getClassLoader());
        this.mWSPushModel = (WSPushOpModel) parcel.readParcelable(WSPushOpModel.class.getClassLoader());
        this.mWSPushGloryKingModel = (WSPushGloryKingModel) parcel.readParcelable(WSPushGloryKingModel.class.getClassLoader());
        this.mWSPushVideoModel = (WSPushVideoModel) parcel.readParcelable(WSPushVideoModel.class.getClassLoader());
        this.mWSPushCommentModel = (WSPushCommentModel) parcel.readParcelable(WSPushCommentModel.class.getClassLoader());
    }

    public static WSPushStrategyInfo getInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new WSPushStrategyInfo(jSONObject);
    }
}
