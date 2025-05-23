package com.tencent.image_picker.imagepicker.features;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image_picker.imagepicker.view.SnackBarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class TencentImagePickerActivity extends AppCompatActivity implements com.tencent.luggage.wxa.x0.g {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.d1.d f116253a = com.tencent.luggage.wxa.d1.d.a();

    /* renamed from: b, reason: collision with root package name */
    public ActionBar f116254b;

    /* renamed from: c, reason: collision with root package name */
    public ProgressBar f116255c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f116256d;

    /* renamed from: e, reason: collision with root package name */
    public RecyclerView f116257e;

    /* renamed from: f, reason: collision with root package name */
    public SnackBarView f116258f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.c1.b f116259g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.x0.e f116260h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.d1.b f116261i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.x0.c f116262j;

    /* renamed from: k, reason: collision with root package name */
    public Handler f116263k;

    /* renamed from: l, reason: collision with root package name */
    public ContentObserver f116264l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f116265m;

    /* loaded from: classes7.dex */
    public class a implements com.tencent.luggage.wxa.e1.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.e1.b
        public boolean a(boolean z16) {
            return TencentImagePickerActivity.this.f116259g.a(z16);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements com.tencent.luggage.wxa.e1.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.e1.a
        public void a(com.tencent.luggage.wxa.f1.a aVar) {
            TencentImagePickerActivity.this.d(aVar.b());
        }
    }

    /* loaded from: classes7.dex */
    public class c implements com.tencent.luggage.wxa.e1.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.x0.c f116268a;

        public c(com.tencent.luggage.wxa.x0.c cVar) {
            this.f116268a = cVar;
        }

        @Override // com.tencent.luggage.wxa.e1.c
        public void a(List list) {
            TencentImagePickerActivity.this.l();
            if (com.tencent.luggage.wxa.d1.a.a((com.tencent.luggage.wxa.a1.a) this.f116268a, false) && !list.isEmpty()) {
                TencentImagePickerActivity.this.m();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TencentImagePickerActivity.this.o();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TencentImagePickerActivity.this.o();
        }
    }

    /* loaded from: classes7.dex */
    public class f extends ContentObserver {
        public f(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            TencentImagePickerActivity.this.i();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements com.tencent.luggage.wxa.c1.a {
        public g() {
        }

        @Override // com.tencent.luggage.wxa.c1.a
        public void a() {
            TencentImagePickerActivity.this.l();
        }

        @Override // com.tencent.luggage.wxa.c1.a
        public void b() {
            TencentImagePickerActivity.this.setResult(0);
            TencentImagePickerActivity.this.finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(com.tencent.luggage.wxa.d1.e.a(context));
    }

    public final boolean f() {
        boolean z16;
        boolean z17 = false;
        if (ContextCompat.checkSelfPermission(this, QQPermissionConstants.Permission.CAMERA) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (ContextCompat.checkSelfPermission(this, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            z17 = true;
        }
        if (z16 && z17) {
            return e();
        }
        this.f116253a.c("Camera permission is not granted. Requesting permission");
        p();
        return true;
    }

    public final com.tencent.luggage.wxa.a1.a g() {
        if (this.f116265m) {
            return h();
        }
        return k();
    }

    public final com.tencent.luggage.wxa.z0.a h() {
        return (com.tencent.luggage.wxa.z0.a) getIntent().getParcelableExtra(com.tencent.luggage.wxa.z0.a.class.getSimpleName());
    }

    public final void i() {
        com.tencent.luggage.wxa.x0.c k3 = k();
        this.f116260h.e();
        if (k3 != null) {
            this.f116260h.a(k3);
        }
    }

    public final void j() {
        if (ContextCompat.checkSelfPermission(this, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            i();
        } else {
            q();
        }
    }

    public final com.tencent.luggage.wxa.x0.c k() {
        if (this.f116262j == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                this.f116262j = (com.tencent.luggage.wxa.x0.c) extras.getParcelable(com.tencent.luggage.wxa.x0.c.class.getSimpleName());
            } else {
                throw new IllegalStateException("This should not happen. Please open an issue!");
            }
        }
        return this.f116262j;
    }

    public final void l() {
        supportInvalidateOptionsMenu();
        this.f116254b.setTitle(this.f116259g.c());
    }

    public final void m() {
        this.f116260h.a(this.f116259g.b());
    }

    public final void o() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getPackageName(), null));
        intent.addFlags(268435456);
        com.tencent.luggage.wxa.fa.b.a(this, intent);
        startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 2000) {
            if (i16 == -1) {
                this.f116260h.a(this, intent, g());
            } else if (i16 == 0 && this.f116265m) {
                this.f116260h.d();
                finish();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f116265m) {
            super.onBackPressed();
        } else {
            this.f116259g.a(new g());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.luggage.wxa.c1.b bVar = this.f116259g;
        if (bVar != null) {
            bVar.a(configuration.orientation);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            this.f116265m = getIntent().hasExtra(com.tencent.luggage.wxa.z0.a.class.getSimpleName());
            r();
            if (this.f116265m) {
                if (bundle == null && !f()) {
                    finish();
                    return;
                }
                return;
            }
            com.tencent.luggage.wxa.x0.c k3 = k();
            if (k3 != null) {
                setTheme(k3.m());
                setContentView(R.layout.dr5);
                b(k3);
                a(k3);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.d1.d.a().b("This should not happen. Please open an issue!");
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.f169219i, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.tencent.luggage.wxa.x0.e eVar = this.f116260h;
        if (eVar != null) {
            eVar.e();
            this.f116260h.a();
        }
        if (this.f116264l != null) {
            getContentResolver().unregisterContentObserver(this.f116264l);
            this.f116264l = null;
        }
        Handler handler = this.f116263k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f116263k = null;
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == R.id.z3p) {
            m();
            return true;
        }
        if (itemId == R.id.z3j) {
            f();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        com.tencent.luggage.wxa.x0.c k3;
        MenuItem findItem = menu.findItem(R.id.z3j);
        if (findItem != null && (k3 = k()) != null) {
            findItem.setVisible(k3.q());
        }
        MenuItem findItem2 = menu.findItem(R.id.z3p);
        if (findItem2 != null) {
            findItem2.setTitle(com.tencent.luggage.wxa.d1.a.a(this, this.f116262j));
            findItem2.setVisible(this.f116259g.e());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        Object obj = "(empty)";
        if (i3 != 23) {
            if (i3 != 24) {
                this.f116253a.a("Got unexpected permission result: " + i3);
                super.onRequestPermissionsResult(i3, strArr, iArr);
                return;
            }
            if (iArr.length != 0 && iArr[0] == 0) {
                this.f116253a.a("Camera permission granted");
                e();
                return;
            }
            com.tencent.luggage.wxa.d1.d dVar = this.f116253a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Permission not granted: results len = ");
            sb5.append(iArr.length);
            sb5.append(" Result code = ");
            if (iArr.length > 0) {
                obj = Integer.valueOf(iArr[0]);
            }
            sb5.append(obj);
            dVar.b(sb5.toString());
            finish();
            return;
        }
        if (iArr.length != 0 && iArr[0] == 0) {
            this.f116253a.a("Write External permission granted");
            i();
            return;
        }
        com.tencent.luggage.wxa.d1.d dVar2 = this.f116253a;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Permission not granted: results len = ");
        sb6.append(iArr.length);
        sb6.append(" Result code = ");
        if (iArr.length > 0) {
            obj = Integer.valueOf(iArr[0]);
        }
        sb6.append(obj);
        dVar2.b(sb6.toString());
        finish();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f116260h.a((com.tencent.luggage.wxa.y0.b) bundle.getSerializable("Key.CameraModule"));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.f116265m) {
            j();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("Key.CameraModule", this.f116260h.f());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.f116265m) {
            return;
        }
        if (this.f116263k == null) {
            this.f116263k = new Handler();
        }
        this.f116264l = new f(this.f116263k);
        getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f116264l);
    }

    public final void p() {
        this.f116253a.c("Write External permission is not granted. Requesting permission");
        ArrayList arrayList = new ArrayList(2);
        if (ContextCompat.checkSelfPermission(this, QQPermissionConstants.Permission.CAMERA) != 0) {
            arrayList.add(QQPermissionConstants.Permission.CAMERA);
        }
        if (ContextCompat.checkSelfPermission(this, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            arrayList.add(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        }
        if (b(arrayList)) {
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 24);
            return;
        }
        if (!this.f116261i.a("cameraRequested")) {
            this.f116261i.b("cameraRequested");
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[arrayList.size()]), 24);
        } else if (this.f116265m) {
            Toast.makeText(getApplicationContext(), getString(R.string.f241517s3), 0).show();
            finish();
        } else {
            this.f116258f.b(R.string.f241517s3, new e());
        }
    }

    public final void q() {
        this.f116253a.c("Write External permission is not granted. Requesting permission");
        String[] strArr = {QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE};
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(this, strArr, 23);
        } else if (!this.f116261i.a("writeExternalRequested")) {
            this.f116261i.b("writeExternalRequested");
            ActivityCompat.requestPermissions(this, strArr, 23);
        } else {
            this.f116258f.b(R.string.f241527s4, new d());
        }
    }

    public final void r() {
        this.f116261i = new com.tencent.luggage.wxa.d1.b(this);
        com.tencent.luggage.wxa.x0.e eVar = new com.tencent.luggage.wxa.x0.e(new com.tencent.luggage.wxa.x0.a(this));
        this.f116260h = eVar;
        eVar.a(this);
    }

    public final void b(com.tencent.luggage.wxa.x0.c cVar) {
        this.f116255c = (ProgressBar) findViewById(R.id.g1o);
        this.f116256d = (TextView) findViewById(R.id.f107696b4);
        this.f116257e = (RecyclerView) findViewById(R.id.i4l);
        this.f116258f = (SnackBarView) findViewById(R.id.ura);
        setSupportActionBar((Toolbar) findViewById(R.id.f99425pr));
        ActionBar supportActionBar = getSupportActionBar();
        this.f116254b = supportActionBar;
        if (supportActionBar != null) {
            Drawable a16 = com.tencent.luggage.wxa.d1.f.a(this);
            int c16 = cVar.c();
            if (c16 != -1 && a16 != null) {
                a16.setColorFilter(c16, PorterDuff.Mode.SRC_ATOP);
            }
            this.f116254b.setDisplayHomeAsUpEnabled(true);
            this.f116254b.setHomeAsUpIndicator(a16);
            this.f116254b.setDisplayShowTitleEnabled(true);
        }
    }

    public final void c(List list) {
        this.f116259g.a(list);
        l();
    }

    public final void d(List list) {
        this.f116259g.b(list);
        l();
    }

    public final boolean e() {
        if (!com.tencent.luggage.wxa.y0.a.a(this)) {
            return false;
        }
        this.f116260h.a(this, g(), 2000);
        return true;
    }

    public final void a(com.tencent.luggage.wxa.x0.c cVar) {
        com.tencent.luggage.wxa.c1.b bVar = new com.tencent.luggage.wxa.c1.b(this.f116257e, cVar, getResources().getConfiguration().orientation);
        this.f116259g = bVar;
        bVar.a(new a(), new b());
        this.f116259g.a(new c(cVar));
    }

    @Override // com.tencent.luggage.wxa.x0.g
    public void d() {
        j();
    }

    @Override // com.tencent.luggage.wxa.x0.g
    public void a(List list) {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("selectedImages", (ArrayList) list);
        setResult(-1, intent);
        finish();
    }

    @Override // com.tencent.luggage.wxa.x0.g
    public void a(List list, List list2) {
        com.tencent.luggage.wxa.x0.c k3 = k();
        if (k3 != null && k3.n()) {
            c(list2);
        } else {
            d(list);
        }
    }

    @Override // com.tencent.luggage.wxa.x0.g
    public void a(Throwable th5) {
        Toast.makeText(this, (th5 == null || !(th5 instanceof NullPointerException)) ? "Unknown Error" : "Images not exist", 0).show();
    }

    public final boolean b(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, (String) list.get(i3))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.x0.g
    public void a(boolean z16) {
        this.f116255c.setVisibility(z16 ? 0 : 8);
        this.f116257e.setVisibility(z16 ? 8 : 0);
        this.f116256d.setVisibility(8);
    }

    @Override // com.tencent.luggage.wxa.x0.g
    public void a() {
        this.f116255c.setVisibility(8);
        this.f116257e.setVisibility(8);
        this.f116256d.setVisibility(0);
    }
}
