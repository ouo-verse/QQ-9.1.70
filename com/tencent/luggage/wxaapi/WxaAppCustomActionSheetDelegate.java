package com.tencent.luggage.wxaapi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.so.c;
import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface WxaAppCustomActionSheetDelegate {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ActionItem implements Parcelable {
        public static final Parcelable.Creator<ActionItem> CREATOR = new a();
        public boolean C;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        public ActionType f146876d;

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        public String f146877e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public String f146878f;

        /* renamed from: h, reason: collision with root package name */
        @DrawableRes
        public int f146879h;

        /* renamed from: i, reason: collision with root package name */
        public int f146880i;

        /* renamed from: m, reason: collision with root package name */
        public int f146881m;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Parcelable.Creator<ActionItem> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ActionItem createFromParcel(Parcel parcel) {
                return new ActionItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ActionItem[] newArray(int i3) {
                return new ActionItem[i3];
            }
        }

        public ActionItem() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int ordinal;
            ActionType actionType = this.f146876d;
            if (actionType == null) {
                ordinal = -1;
            } else {
                ordinal = actionType.ordinal();
            }
            parcel.writeInt(ordinal);
            parcel.writeString(this.f146877e);
            parcel.writeString(this.f146878f);
            parcel.writeInt(this.f146879h);
            parcel.writeInt(this.f146880i);
            parcel.writeInt(this.f146881m);
            parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        }

        public ActionItem(Parcel parcel) {
            int readInt = parcel.readInt();
            this.f146876d = readInt == -1 ? null : ActionType.values()[readInt];
            this.f146877e = parcel.readString();
            this.f146878f = parcel.readString();
            this.f146879h = parcel.readInt();
            this.f146880i = parcel.readInt();
            this.f146881m = parcel.readInt();
            this.C = parcel.readByte() > 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum ActionType {
        onShareAPPMessage,
        onAddToFavorites,
        onAddToMine;

        private static final com.tencent.luggage.wxa.so.c ENTRIES = com.tencent.luggage.wxa.so.c.a(new c.a() { // from class: com.tencent.luggage.wxaapi.l
            @Override // com.tencent.luggage.wxa.so.c.a
            public final Object a() {
                List lambda$static$0;
                lambda$static$0 = WxaAppCustomActionSheetDelegate.ActionType.lambda$static$0();
                return lambda$static$0;
            }
        });

        public static List<ActionType> getEntries() {
            return (List) ENTRIES.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ List lambda$static$0() {
            return Arrays.asList(values());
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void onCancel();

        void onFail(String str);

        void onSuccess();
    }

    void handleCustomAction(@NonNull String str, int i3, int i16, @Nullable JSONObject jSONObject, @NonNull a aVar);

    @Nullable
    List<ActionItem> provideCustomActionItems(String str);
}
