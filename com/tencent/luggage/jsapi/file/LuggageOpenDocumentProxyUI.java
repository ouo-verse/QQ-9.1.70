package com.tencent.luggage.jsapi.file;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.jsapi.file.LuggageOpenDocumentProxyUI;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.bo.e;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

/* loaded from: classes2.dex */
public class LuggageOpenDocumentProxyUI extends com.tencent.luggage.wxa.mo.b {
    public ResultReceiver Q;

    /* loaded from: classes2.dex */
    public class a implements ValueCallback {
        public a() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            w.d("Luggage.OpenDocumentProxyUI", "openReadFile, receiveValue = %s", str);
            if (str == "fileReaderClosed") {
                LuggageOpenDocumentProxyUI.this.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f119999a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f120000b;

        /* loaded from: classes2.dex */
        public class a implements LuggageActivityHelper.d {
            public a() {
            }

            @Override // com.tencent.luggage.util.LuggageActivityHelper.d
            public void a(int i3, Intent intent) {
                LuggageOpenDocumentProxyUI.this.b(i3);
            }
        }

        public b(String str, String str2) {
            this.f119999a = str;
            this.f120000b = str2;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(Integer num) {
            w.d("Luggage.OpenDocumentProxyUI", "openReadFile, ret = %d", num);
            if (num.intValue() == -102) {
                LuggageOpenDocumentProxyUI.this.finish();
                try {
                    LuggageOpenDocumentProxyUI luggageOpenDocumentProxyUI = LuggageOpenDocumentProxyUI.this;
                    luggageOpenDocumentProxyUI.a(luggageOpenDocumentProxyUI, this.f119999a, this.f120000b, new a());
                    return;
                } catch (Exception e16) {
                    w.a("Luggage.OpenDocumentProxyUI", e16, " openOuterAppDirectly exp = %s ", e16);
                }
            }
            LuggageOpenDocumentProxyUI.this.b(num.intValue());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.y9.a.makeText(z.c(), R.string.yz_, 0).show();
        }
    }

    public final void b(int i3) {
        this.Q.send(i3, null);
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mm.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        final String stringExtra = intent.getStringExtra("filePath");
        final String stringExtra2 = intent.getStringExtra(WadlProxyConsts.PARAM_FILENAME);
        final String stringExtra3 = intent.getStringExtra("fileExt");
        this.Q = (ResultReceiver) intent.getParcelableExtra("receiver");
        final HashMap hashMap = new HashMap();
        final a aVar = new a();
        final b bVar = new b(stringExtra, stringExtra3);
        final String num = Integer.toString(hashCode());
        h.f146825d.a(new Runnable() { // from class: y11.a
            @Override // java.lang.Runnable
            public final void run() {
                LuggageOpenDocumentProxyUI.this.a(stringExtra, stringExtra2, stringExtra3, num, hashMap, aVar, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, HashMap hashMap, ValueCallback valueCallback, ValueCallback valueCallback2) {
        com.tencent.luggage.wxa.b6.a.a(this, str, str2, str3, str4, false, hashMap, valueCallback, valueCallback2, false);
    }

    public final void a(Context context, String str, String str2, LuggageActivityHelper.d dVar) {
        Uri fromFile;
        String c16 = e.c(str2);
        if (!StringUtils.endsWith(str, str2)) {
            String str3 = str + "." + str2;
            x.a(str, str3, false);
            str = str3;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(null);
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            File file = new File(str);
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(context, z.h() + ".shareFileProvide", file);
                intent.addFlags(1);
            } else {
                fromFile = Uri.fromFile(file);
            }
            w.d("Luggage.OpenDocumentProxyUI", "openOuterAppDirectly: uri = " + fromFile.toString());
            intent.setDataAndType(fromFile, c16);
            intent.addFlags(268435456);
            intent.addFlags(524288);
            LuggageActivityHelper.FOR(context).startActivityForResult(intent, dVar);
        } catch (Exception e16) {
            w.b("Luggage.OpenDocumentProxyUI", "start outer view with mime(%s), e = %s", c16, e16);
            c0.a(new c());
        }
    }
}
