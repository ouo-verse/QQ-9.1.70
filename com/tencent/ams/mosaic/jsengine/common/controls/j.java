package com.tencent.ams.mosaic.jsengine.common.controls;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.MosaicView;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j implements IControls {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Context f70867a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.ams.mosaic.jsengine.a f70868b;

    /* renamed from: c, reason: collision with root package name */
    private final MosaicView f70869c;

    public j(@NonNull Context context, @NonNull com.tencent.ams.mosaic.jsengine.a aVar, MosaicView mosaicView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, aVar, mosaicView);
            return;
        }
        this.f70867a = context;
        this.f70868b = aVar;
        this.f70869c = mosaicView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(JSFunction jSFunction, DialogInterface dialogInterface, int i3) {
        if (jSFunction != null) {
            this.f70868b.u(jSFunction, new Object[]{Integer.valueOf(i3)}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(JSFunction jSFunction, DialogInterface dialogInterface) {
        if (jSFunction != null) {
            this.f70868b.u(jSFunction, new Object[0], null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(String str, String[] strArr, String str2, final JSFunction jSFunction, final JSFunction jSFunction2, JSFunction jSFunction3, JSFunction jSFunction4) {
        ActionSheetDialog actionSheetDialog = new ActionSheetDialog(this.f70867a);
        actionSheetDialog.o(str, strArr, str2, new DialogInterface.OnClickListener() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.this.i(jSFunction, dialogInterface, i3);
            }
        });
        actionSheetDialog.p(new DialogInterface.OnCancelListener() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.i
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                j.this.j(jSFunction2, dialogInterface);
            }
        });
        if (actionSheetDialog.q()) {
            com.tencent.ams.mosaic.utils.f.e("Controls", "showActionSheet success");
            if (jSFunction3 != null) {
                this.f70868b.u(jSFunction3, new Object[0], null);
                return;
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("Controls", "showActionSheet failed");
        if (jSFunction4 != null) {
            this.f70868b.u(jSFunction4, new Object[]{"dialog.show failed"}, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(JSFunction jSFunction, DialogInterface dialogInterface, int i3) {
        if (jSFunction != null) {
            this.f70868b.u(jSFunction, new Object[0], null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(JSFunction jSFunction, DialogInterface dialogInterface, int i3) {
        if (jSFunction != null) {
            this.f70868b.u(jSFunction, new Object[0], null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(JSFunction jSFunction, DialogInterface dialogInterface) {
        if (jSFunction != null) {
            this.f70868b.u(jSFunction, new Object[0], null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener, JSFunction jSFunction, boolean z16, JSFunction jSFunction2) {
        Dialog a16;
        com.tencent.ams.mosaic.b o16 = com.tencent.ams.mosaic.f.k().o();
        if (o16 != null && (a16 = o16.a(MosaicUtils.m(this.f70867a), str, str2, str3, onClickListener, str4, onClickListener2, onCancelListener)) != null) {
            a16.show();
            if (jSFunction != null) {
                this.f70868b.u(jSFunction, new Object[0], null);
                return;
            }
            return;
        }
        try {
            AlertDialog.Builder onCancelListener2 = new AlertDialog.Builder(this.f70867a).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setOnCancelListener(onCancelListener);
            if (z16) {
                onCancelListener2.setNegativeButton(str4, onClickListener2);
            }
            onCancelListener2.show();
            if (jSFunction != null) {
                this.f70868b.u(jSFunction, new Object[0], null);
            }
            com.tencent.ams.mosaic.utils.f.e("Controls", "showAlertDialog success");
        } catch (Throwable th5) {
            com.tencent.ams.mosaic.utils.f.i("Controls", "showAlertDialog failed", th5);
            if (jSFunction2 != null) {
                this.f70868b.u(jSFunction2, new Object[0], null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(String str, int i3) {
        int i16;
        Context context = this.f70867a;
        if (i3 > 1500) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        Toast.makeText(context, str, i16).show();
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.controls.IControls
    public void hideKeyboard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f70867a.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f70869c.getView().getWindowToken(), 2);
            }
            com.tencent.ams.mosaic.utils.f.e("Controls", "hideKeyboard success");
        } catch (Throwable unused) {
            com.tencent.ams.mosaic.utils.f.h("Controls", "hideKeyboard failed");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.controls.IControls
    public void showActionSheet(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSObject);
            return;
        }
        Map<String, Object> f16 = com.tencent.ams.mosaic.jsengine.e.f(this.f70868b.l(), jSObject);
        if (f16 == null) {
            com.tencent.ams.mosaic.utils.f.h("Controls", "showActionSheet failed: invalid infoDict");
            return;
        }
        final String d16 = com.tencent.ams.mosaic.jsengine.e.d(f16.get("title"), null);
        final String[] e16 = com.tencent.ams.mosaic.jsengine.e.e(f16.get(VideoTemplateParser.ITEM_LIST), null);
        final String d17 = com.tencent.ams.mosaic.jsengine.e.d(f16.get("cancelText"), "\u53d6\u6d88");
        final JSFunction c16 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onSuccess"));
        final JSFunction c17 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onFail"));
        final JSFunction c18 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onSelect"));
        final JSFunction c19 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onCancel"));
        if (e16 != null && e16.length != 0) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.g
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.k(d16, e16, d17, c18, c19, c16, c17);
                }
            });
        } else if (c17 != null) {
            this.f70868b.u(c17, new Object[]{"itemList is empty"}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.controls.IControls
    public void showAlertDialog(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSObject);
            return;
        }
        Map<String, Object> f16 = com.tencent.ams.mosaic.jsengine.e.f(this.f70868b.l(), jSObject);
        final String d16 = com.tencent.ams.mosaic.jsengine.e.d(f16.get("title"), null);
        final String d17 = com.tencent.ams.mosaic.jsengine.e.d(f16.get("message"), null);
        final String d18 = com.tencent.ams.mosaic.jsengine.e.d(f16.get("confirmText"), "\u786e\u5b9a");
        final String d19 = com.tencent.ams.mosaic.jsengine.e.d(f16.get("cancelText"), "\u53d6\u6d88");
        final boolean b16 = com.tencent.ams.mosaic.jsengine.e.b(f16.get("showCancel"), true);
        final JSFunction c16 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onSuccess"));
        final JSFunction c17 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onFail"));
        final JSFunction c18 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onCancel"));
        final JSFunction c19 = com.tencent.ams.mosaic.jsengine.e.c(f16.get("onConfirm"));
        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.this.l(c19, dialogInterface, i3);
            }
        };
        final DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                j.this.m(c18, dialogInterface, i3);
            }
        };
        final DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                j.this.n(c18, dialogInterface);
            }
        };
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.f
            @Override // java.lang.Runnable
            public final void run() {
                j.this.o(d16, d17, d18, onClickListener, d19, onClickListener2, onCancelListener, c16, b16, c17);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.controls.IControls
    public void showToast(final String str, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.b
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.p(str, i3);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.controls.IControls
    public void vibrate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            MosaicUtils.a0(this.f70867a, i3);
        }
    }
}
