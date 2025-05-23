package com.tencent.luggage.wxa.ve;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.view.MenuItem;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.mo.h;
import com.tencent.luggage.wxa.mo.p;
import com.tencent.luggage.wxa.mo.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.ve.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f143380a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ve.a f143381b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f143382c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f143383d;

        public a(Context context, com.tencent.luggage.wxa.ve.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f143380a = context;
            this.f143381b = aVar;
            this.f143382c = dVar;
            this.f143383d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a((Activity) this.f143380a, this.f143381b, this.f143382c, this.f143383d);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ve.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6842b implements p {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f143385a;

        public C6842b(String[] strArr) {
            this.f143385a = strArr;
        }

        @Override // com.tencent.luggage.wxa.mo.p
        public void a(h hVar) {
            hVar.add(0, this.f143385a[0]);
            hVar.add(1, this.f143385a[1]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements u {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ve.a f143387a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f143388b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f143389c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f143390d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements LuggageActivityHelper.d {
            public a() {
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public void a(int i3, Intent intent) {
                if (i3 == 0) {
                    c cVar = c.this;
                    cVar.f143389c.a(cVar.f143390d, b.this.makeReturnJson("cancel"));
                } else {
                    c cVar2 = c.this;
                    cVar2.f143389c.a(cVar2.f143390d, b.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ve.b$c$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6843b implements LuggageActivityHelper.d {
            public C6843b() {
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public void a(int i3, Intent intent) {
                if (i3 == 0) {
                    c cVar = c.this;
                    cVar.f143389c.a(cVar.f143390d, b.this.makeReturnJson("cancel"));
                } else {
                    c cVar2 = c.this;
                    cVar2.f143389c.a(cVar2.f143390d, b.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                }
            }
        }

        public c(com.tencent.luggage.wxa.ve.a aVar, Activity activity, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f143387a = aVar;
            this.f143388b = activity;
            this.f143389c = dVar;
            this.f143390d = i3;
        }

        @Override // com.tencent.luggage.wxa.mo.u
        public void a(MenuItem menuItem, int i3) {
            if (i3 != 0) {
                if (i3 == 1) {
                    Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
                    intent.setType("vnd.android.cursor.item/person");
                    b.this.a(intent, this.f143387a, this.f143388b, this.f143389c);
                    C6843b c6843b = new C6843b();
                    try {
                        LuggageActivityHelper.FOR(this.f143388b).startActivityForResultThrows(intent, c6843b);
                        return;
                    } catch (RemoteException e16) {
                        w.b("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case1, get RemoteException[%s] retry", e16);
                        LuggageActivityHelper.FOR(this.f143388b).startActivityForResult(intent, c6843b);
                        return;
                    }
                }
                return;
            }
            Intent intent2 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            b.this.a(intent2, this.f143387a, this.f143388b, this.f143389c);
            Activity activity = this.f143388b;
            com.tencent.luggage.wxa.fa.b.a(activity, intent2);
            activity.startActivity(intent2);
            a aVar = new a();
            try {
                LuggageActivityHelper.FOR(this.f143388b).startActivityForResultThrows(intent2, aVar);
            } catch (RemoteException e17) {
                w.b("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case0, get RemoteException[%s] retry", e17);
                b.b(intent2);
                LuggageActivityHelper.FOR(this.f143388b).startActivityForResult(intent2, aVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements MMBottomSheet.CancelBtnCallBack {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f143394a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f143395b;

        public d(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f143394a = dVar;
            this.f143395b = i3;
        }

        @Override // com.tencent.mm.ui.widget.dialog.MMBottomSheet.CancelBtnCallBack
        public void onClick() {
            this.f143394a.a(this.f143395b, b.this.makeReturnJson("cancel"));
        }
    }

    public static void b(Intent intent) {
        ContentValues contentValues;
        try {
            ArrayList<? extends Parcelable> parcelableArrayListExtra = intent.getParcelableArrayListExtra("data");
            Iterator<? extends Parcelable> it = parcelableArrayListExtra.iterator();
            while (true) {
                if (!it.hasNext()) {
                    contentValues = null;
                    break;
                } else {
                    contentValues = (ContentValues) it.next();
                    if (contentValues.containsKey("data15")) {
                        break;
                    }
                }
            }
            if (contentValues != null) {
                parcelableArrayListExtra.remove(contentValues);
            }
            intent.putParcelableArrayListExtra("data", parcelableArrayListExtra);
        } catch (Throwable th5) {
            w.a("MicroMsg.JsApiAddPhoneContact", th5, "removeContactAvatarDataFromIntent", new Object[0]);
        }
    }

    public final void c(ArrayList arrayList, String str, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, Integer.valueOf(i3));
        arrayList.add(contentValues);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.JsApiAddPhoneContact", "data is null");
            return;
        }
        if (w0.c(jSONObject.optString(UserInfo.FIRSTNAME))) {
            dVar.a(i3, makeReturnJson("fail:firstName is null"));
            w.b("MicroMsg.JsApiAddPhoneContact", "firstName is null");
            return;
        }
        Context context = dVar.getContext();
        if (context != null && (context instanceof Activity)) {
            dVar.a(new a(context, a(jSONObject), dVar, i3));
        } else {
            dVar.a(i3, makeReturnJson("fail"));
            w.b("MicroMsg.JsApiAddPhoneContact", "activity is null, invoke fail!");
        }
    }

    public final com.tencent.luggage.wxa.ve.a a(JSONObject jSONObject) {
        com.tencent.luggage.wxa.ve.a aVar = new com.tencent.luggage.wxa.ve.a();
        aVar.h(jSONObject.optString("photoFilePath"));
        aVar.f(jSONObject.optString("nickName"));
        aVar.a(new a.b(jSONObject.optString(UserInfo.FIRSTNAME), jSONObject.optString("middleName"), jSONObject.optString(UserInfo.LASTNAME)));
        aVar.i(jSONObject.optString("remark"));
        aVar.e(jSONObject.optString("mobilePhoneNumber"));
        aVar.l(jSONObject.optString("weChatNumber"));
        aVar.a(a(jSONObject, "address"));
        aVar.g(jSONObject.optString("organization"));
        aVar.j(jSONObject.optString("title"));
        aVar.m(jSONObject.optString("workFaxNumber"));
        aVar.n(jSONObject.optString("workPhoneNumber"));
        aVar.d(jSONObject.optString("hostNumber"));
        aVar.a(jSONObject.optString("email"));
        aVar.k(jSONObject.optString("url"));
        aVar.c(a(jSONObject, "workAddress"));
        aVar.b(jSONObject.optString("homeFaxNumber"));
        aVar.c(jSONObject.optString("homePhoneNumber"));
        aVar.b(a(jSONObject, "homeAddress"));
        return aVar;
    }

    public final void b(ArrayList arrayList, String str, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, Integer.valueOf(i3));
        arrayList.add(contentValues);
    }

    public final a.C6841a a(JSONObject jSONObject, String str) {
        return new a.C6841a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
    }

    public final void a(Activity activity, com.tencent.luggage.wxa.ve.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        String[] strArr = {activity.getString(R.string.f1639924m), activity.getString(R.string.f1639824l)};
        MMBottomSheet mMBottomSheet = new MMBottomSheet((Context) activity, 1, false);
        mMBottomSheet.setOnCreateMenuListener(new C6842b(strArr));
        mMBottomSheet.setOnMenuSelectedListener(new c(aVar, activity, dVar, i3));
        mMBottomSheet.setCancelBtnClickListener(new d(dVar, i3));
        mMBottomSheet.tryShow();
    }

    public final void a(Intent intent, com.tencent.luggage.wxa.ve.a aVar, Activity activity, com.tencent.luggage.wxa.xd.d dVar) {
        Bitmap a16;
        intent.setFlags(268435456);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        a(arrayList, aVar, intent);
        if (!w0.c(aVar.i())) {
            a(arrayList, aVar.i(), 1);
        }
        if (!w0.c(aVar.l())) {
            a(arrayList, aVar.l());
        }
        if (!w0.c(aVar.j()) || !w0.c(aVar.m())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/organization");
            if (!w0.c(aVar.j())) {
                contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, aVar.j());
            }
            if (!w0.c(aVar.m())) {
                contentValues.put("data4", aVar.m());
            }
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 1);
            arrayList.add(contentValues);
        }
        if (!w0.c(aVar.n())) {
            c(arrayList, aVar.n(), 1);
        }
        if (!w0.c(aVar.c())) {
            intent.putExtra("email", aVar.c());
        }
        if (!w0.c(aVar.h())) {
            b(arrayList, aVar.h(), 2);
        }
        if (!w0.c(aVar.f())) {
            b(arrayList, aVar.f(), 1);
        }
        if (!w0.c(aVar.r())) {
            b(arrayList, aVar.r(), 3);
        }
        if (!w0.c(aVar.g())) {
            b(arrayList, aVar.g(), 10);
        }
        if (!w0.c(aVar.e())) {
            b(arrayList, aVar.e(), 5);
        }
        if (!w0.c(aVar.q())) {
            b(arrayList, aVar.q(), 4);
        }
        a(arrayList, aVar.a(), 3);
        a(arrayList, aVar.p(), 2);
        a(arrayList, aVar.d(), 1);
        if (!w0.c(aVar.o())) {
            a(arrayList, aVar.o(), -1, activity.getString(R.string.f238677ke));
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(aVar.k());
        if (absoluteFile != null && absoluteFile.e()) {
            try {
                Bitmap a17 = MMBitmapFactory.a(absoluteFile.g());
                if (a17 != null && (a16 = a(a17)) != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    a16.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("mimetype", "vnd.android.cursor.item/photo");
                    contentValues2.put("data15", byteArray);
                    arrayList.add(contentValues2);
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th5) {
                        w.a("MicroMsg.JsApiAddPhoneContact", th5, "processContactIntent, close avatar stream", new Object[0]);
                    }
                    try {
                        a16.recycle();
                    } catch (Throwable unused) {
                    }
                }
            } catch (OutOfMemoryError unused2) {
                w.b("MicroMsg.JsApiAddPhoneContact", "processContactIntent, put avatar bitmap oom, file=%s", absoluteFile);
            }
        }
        intent.putParcelableArrayListExtra("data", arrayList);
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap createScaledBitmap;
        if (bitmap.getByteCount() <= 819200) {
            return bitmap;
        }
        while (true) {
            createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
            try {
                bitmap.recycle();
            } catch (Throwable unused) {
            }
            if (createScaledBitmap == null || createScaledBitmap.getByteCount() <= 819200) {
                break;
            }
            bitmap = createScaledBitmap;
        }
        return createScaledBitmap;
    }

    public final void a(ArrayList arrayList, a.C6841a c6841a, int i3) {
        if (c6841a == null || c6841a.c().length() <= 0) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, c6841a.c());
        contentValues.put("data9", c6841a.d());
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, Integer.valueOf(i3));
        arrayList.add(contentValues);
    }

    public final void a(ArrayList arrayList, String str, int i3, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        contentValues.put("data5", Integer.valueOf(i3));
        contentValues.put("data6", str2);
        arrayList.add(contentValues);
    }

    public final void a(ArrayList arrayList, com.tencent.luggage.wxa.ve.a aVar, Intent intent) {
        String a16 = aVar.b().a();
        if (!w0.c(a16)) {
            intent.putExtra("name", a16);
        } else {
            w.b("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        }
    }

    public final void a(ArrayList arrayList, String str, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, Integer.valueOf(i3));
        arrayList.add(contentValues);
    }

    public final void a(ArrayList arrayList, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
        arrayList.add(contentValues);
    }
}
