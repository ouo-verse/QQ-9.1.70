package com.hihonor.honorid.usecase;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.honorid.UseCase;
import com.hihonor.honorid.core.data.HonorAccount;
import h45.c;
import java.util.ArrayList;
import l2.b;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class WriteHnAccountUseCase extends UseCase<RequestValues> {

    /* renamed from: b, reason: collision with root package name */
    private Context f36332b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<HonorAccount> f36333c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f36334d;

    public WriteHnAccountUseCase(Context context, ArrayList<HonorAccount> arrayList, boolean z16) {
        this.f36332b = context;
        this.f36333c = arrayList;
        this.f36334d = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.honorid.UseCase
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void b(RequestValues requestValues) {
        e.c("WriteHnAccountUseCase", "writeHnAccount", true);
        c.d(this.f36332b, "accounts.xml");
        try {
            b.e(this.f36332b, "accounts.xml", this.f36333c, this.f36334d);
        } catch (Exception unused) {
            e.e("WriteHnAccountUseCase", "Exception", true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class RequestValues extends UseCase.RequestValues {
        public static final Parcelable.Creator<RequestValues> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private String f36335d;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<RequestValues> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RequestValues createFromParcel(Parcel parcel) {
                return new RequestValues(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public RequestValues[] newArray(int i3) {
                return new RequestValues[i3];
            }
        }

        public RequestValues(String str) {
            this.f36335d = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f36335d);
        }

        protected RequestValues(Parcel parcel) {
            this.f36335d = parcel.readString();
        }
    }
}
