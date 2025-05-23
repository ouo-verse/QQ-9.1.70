package com.tencent.luggage.wxa.b6;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.lo.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xa.e;
import com.tencent.luggage.wxa.xa.h;
import com.tencent.mobileqq.R;
import com.tencent.xweb.CommandCfgPlugin;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.XFileSdk;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f121874a = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f121876a;

        public b(ValueCallback valueCallback) {
            this.f121876a = valueCallback;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(Integer num) {
            w.d("Luggage.FileReaderLogic", "readFileByXWeb onReceiveValue: " + num);
            if (num.intValue() == 0) {
                this.f121876a.onReceiveValue(0);
            } else {
                this.f121876a.onReceiveValue(-102);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f121877a;

        public c(ValueCallback valueCallback) {
            this.f121877a = valueCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f121877a.onReceiveValue("fileReaderClosed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f121878a;

        public d(ValueCallback valueCallback) {
            this.f121878a = valueCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f121878a.onReceiveValue("fileReaderMenuClicked");
        }
    }

    public static void a(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, boolean z16, HashMap hashMap, ValueCallback valueCallback, ValueCallback valueCallback2, boolean z17) {
        if (hashMap != null) {
            hashMap.put("hide_title_bar_right_button", String.valueOf(!z17));
        }
        String a16 = a(str);
        String lowerCase = str3 != null ? str3.toLowerCase() : str3;
        com.tencent.luggage.wxa.b6.c.a();
        Intent intent = new Intent();
        FileReaderHelper.getReaderType(lowerCase, true, intent);
        a(intent.getIntExtra(FileReaderHelper.OPEN_X5_SCENE_STR, 40), appCompatActivity, a16, str2, lowerCase, str4, false, CommandCfgPlugin.getInstance().canDownloadWhenNotInstall(true), hashMap, valueCallback, valueCallback2, z17);
    }

    public static String a(String str) {
        if (w0.c(str)) {
            w.b("Luggage.FileReaderLogic", "getSafeRealPath filePath is empty");
            return str;
        }
        try {
            String b16 = x.b(str, false);
            if (w0.c(b16)) {
                w.b("Luggage.FileReaderLogic", "getSafeRealPath real path is empty, use old path %s", str);
                return str;
            }
            if (b16.equals(str)) {
                w.d("Luggage.FileReaderLogic", "getSafeRealPath real path is the same %s", b16);
                return b16;
            }
            w.d("Luggage.FileReaderLogic", "getSafeRealPath from %s to %s", str, b16);
            return b16;
        } catch (Exception e16) {
            w.b("Luggage.FileReaderLogic", "getSafeRealPath error: %s", e16.getMessage());
            return str;
        }
    }

    public static void a(int i3, AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, boolean z16, boolean z17, HashMap hashMap, ValueCallback valueCallback, ValueCallback valueCallback2, boolean z18) {
        String str5;
        boolean z19;
        String hVar;
        ViewGroup a16 = a(appCompatActivity, str2, valueCallback, z18, false);
        if (a16 == null) {
            w.b("Luggage.FileReaderLogic", "readFileByXWeb contentView is null, return");
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(-102);
                return;
            }
            return;
        }
        HashMap hashMap2 = new HashMap();
        boolean z26 = true;
        hashMap2.put(XFileSdk.PARAM_KEY_EXTRA_PARAM_CAN_DOWNLOAD_WHEN_PLUGIN_ERROR, String.valueOf(CommandCfgPlugin.getInstance().canDownloadWhenPluginError(true)));
        hashMap2.put(XFileSdk.PARAM_KEY_EXTRA_PARAM_OPEN_FILE_FROM, String.valueOf(i3));
        hashMap2.put(XFileSdk.PARAM_KEY_EXTRA_PARAM_IS_QB_INSTALLED, String.valueOf(f121874a));
        if (hashMap != null && (str5 = (String) hashMap.get(XFileSdk.PARAM_KEY_EXTRA_PARAM_OPEN_FILE_SCENE)) != null && !str5.isEmpty()) {
            hashMap2.put(XFileSdk.PARAM_KEY_EXTRA_PARAM_OPEN_FILE_SCENE, str5);
            try {
                if (!FileReaderHelper.DOC_EXT.equalsIgnoreCase(str3) && !FileReaderHelper.DOCX_EXT.equalsIgnoreCase(str3) && !FileReaderHelper.XLS_EXT.equalsIgnoreCase(str3) && !FileReaderHelper.XLSX_EXT.equalsIgnoreCase(str3)) {
                    z19 = false;
                    if (!str5.equalsIgnoreCase("7") || str5.equalsIgnoreCase("10")) {
                        z26 = false;
                    }
                    h hVar2 = new h();
                    hVar2.a(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU_ID, 0);
                    hVar2.a(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU_DISPLAY, appCompatActivity.getString(R.string.f242577uy));
                    e eVar = new e();
                    eVar.put(hVar2);
                    h hVar3 = new h();
                    hVar3.a(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU_ARRAY, eVar);
                    hVar = hVar3.toString();
                    if (z26 && z19 && hVar != null && !hVar.isEmpty()) {
                        hashMap2.put(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU, hVar);
                    }
                }
                z19 = true;
                if (!str5.equalsIgnoreCase("7")) {
                }
                z26 = false;
                h hVar22 = new h();
                hVar22.a(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU_ID, 0);
                hVar22.a(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU_DISPLAY, appCompatActivity.getString(R.string.f242577uy));
                e eVar2 = new e();
                eVar2.put(hVar22);
                h hVar32 = new h();
                hVar32.a(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU_ARRAY, eVar2);
                hVar = hVar32.toString();
                if (z26) {
                    hashMap2.put(XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU, hVar);
                }
            } catch (Throwable th5) {
                w.b("Luggage.FileReaderLogic", "readFileByXWeb jsonObject error, msg: " + th5.getMessage());
            }
        }
        XFileSdk.readFile(str, str3, str4, z17, hashMap2, XFileSdk.ViewType.ListView, appCompatActivity, a16, new C6032a(valueCallback), new b(valueCallback2));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b6.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6032a implements XFileSdk.ActionCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueCallback f121875a;

        public C6032a(ValueCallback valueCallback) {
            this.f121875a = valueCallback;
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onGeneralCallback(String str, HashMap hashMap) {
            ValueCallback valueCallback;
            if (hashMap == null) {
                w.b("Luggage.FileReaderLogic", "onGeneralCallback error, param is null");
                return;
            }
            if (XFileSdk.GENERAL_CALLBACK_NAME_ON_CUSTOM_MENU_CLICK.equals(str)) {
                Object obj = hashMap.get(XFileSdk.GENERAL_CALLBACK_PARAM_KEY_CUSTOM_MENU_ID);
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    w.d("Luggage.FileReaderLogic", "onGeneralCallback onCustomMenuClick, id = " + intValue);
                    if (intValue == 0 && (valueCallback = this.f121875a) != null) {
                        valueCallback.onReceiveValue("xwebFileReaderMenuEditClick");
                    }
                }
            }
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onReachEnd() {
            ValueCallback valueCallback = this.f121875a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue("xwebFileReaderReachEnd");
            }
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onUserOperated() {
            ValueCallback valueCallback = this.f121875a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue("xwebFileReaderUserOperated");
            }
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onUserCancel() {
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onDoubleTap(MotionEvent motionEvent) {
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onPageCountUpdate(int i3) {
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onSingleTap(MotionEvent motionEvent) {
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onThumbnailLoad(int i3, Bitmap bitmap) {
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onPageChange(int i3, int i16, int i17) {
        }

        @Override // com.tencent.xweb.XFileSdk.ActionCallback
        public void onViewStatusChange(int i3, float f16, int i16, int i17, int i18, int i19) {
        }
    }

    public static ViewGroup a(AppCompatActivity appCompatActivity, String str, ValueCallback valueCallback, boolean z16, boolean z17) {
        View inflate = LayoutInflater.from(appCompatActivity).inflate(R.layout.i8m, (ViewGroup) new LinearLayout(appCompatActivity), false);
        TextView textView = (TextView) inflate.findViewById(R.id.f125737mv);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f125747mw);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.f125757mx);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.f125767my);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.f125777mz);
        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.f125717mt);
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.f125707ms);
        if (textView != null && textView2 != null && linearLayout != null && linearLayout2 != null && imageButton != null && linearLayout3 != null && imageButton2 != null) {
            linearLayout2.setVisibility(0);
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new c(valueCallback));
            linearLayout3.setVisibility(0);
            if (z16) {
                imageButton2.setVisibility(0);
                imageButton2.setOnClickListener(new d(valueCallback));
            } else {
                imageButton2.setVisibility(8);
            }
            linearLayout.setVisibility(0);
            textView2.setVisibility(0);
            textView2.setText(R.string.f242677v8);
            textView.setVisibility(0);
            textView.setText(str);
            FrameLayout frameLayout = new FrameLayout(appCompatActivity);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout relativeLayout = new RelativeLayout(appCompatActivity);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setTag(XFileSdk.VIEW_TAG_RELATIVE_LAYOUT);
            frameLayout.addView(relativeLayout);
            Toolbar toolbar = new Toolbar(appCompatActivity);
            toolbar.setLayoutParams(new Toolbar.LayoutParams(-1, -2));
            toolbar.setContentInsetsAbsolute(0, 0);
            toolbar.setTag(XFileSdk.VIEW_TAG_TOOLBAR);
            frameLayout.addView(toolbar);
            int color = appCompatActivity.getResources().getColor(R.color.c7q);
            if (z17) {
                linearLayout.setVisibility(8);
                textView2.setVisibility(8);
                textView.setVisibility(8);
                frameLayout.setBackgroundColor(DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK);
                toolbar.setBackgroundColor(3355443);
                a(appCompatActivity, DownloadCardView.COLOR_BUTTON_BACKGROUND_DARK);
                imageButton.setImageResource(R.drawable.ofr);
                imageButton2.setImageResource(R.drawable.oft);
            } else if (i.g()) {
                frameLayout.setBackgroundColor(-15132391);
                toolbar.setBackgroundColor(color);
                a(appCompatActivity, color);
                imageButton.setImageResource(R.drawable.ofr);
                imageButton2.setImageResource(R.drawable.oft);
            } else {
                frameLayout.setBackgroundColor(-3355444);
                toolbar.setBackgroundColor(color);
                imageButton.setImageResource(R.drawable.ofm);
                imageButton2.setImageResource(R.drawable.ofp);
            }
            appCompatActivity.setContentView(frameLayout);
            appCompatActivity.setSupportActionBar(toolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar == null) {
                return null;
            }
            supportActionBar.setDisplayShowTitleEnabled(false);
            supportActionBar.setDisplayHomeAsUpEnabled(false);
            supportActionBar.setDisplayShowHomeEnabled(false);
            supportActionBar.setDisplayShowCustomEnabled(true);
            supportActionBar.setCustomView(inflate);
            return frameLayout;
        }
        w.b("Luggage.FileReaderLogic", "initView can not find view");
        return null;
    }

    public static void a(Activity activity, int i3) {
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i3);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } catch (Exception e16) {
            w.b("Luggage.FileReaderLogic", "updateStatusBarToDarkMode error ", e16);
        }
    }
}
