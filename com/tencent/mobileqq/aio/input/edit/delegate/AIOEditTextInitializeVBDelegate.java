package com.tencent.mobileqq.aio.input.edit.delegate;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputUtil;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.aio.input.edit.delegate.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.devices.api.IDevicesApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001 B\u000f\u0012\u0006\u0010)\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u0010(J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016R\"\u0010)\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/AIOEditTextInitializeVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/b;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "o", "P", "H", "K", "N", "p", "Landroid/view/View;", "view", "", "v", "u", "w", "B", "r", "y", "", "t", "binding", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "a", "state", HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/b;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "G", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "f", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "mEditText", "<init>", tl.h.F, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOEditTextInitializeVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f189456i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOEditText mEditText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/edit/delegate/AIOEditTextInitializeVBDelegate$a;", "", "", "KEY_EVENT_ENTERT_SWITCH$delegate", "Lkotlin/Lazy;", "b", "()Z", "KEY_EVENT_ENTERT_SWITCH", "", "KEY_DISABLE_SOUGOU_PTT", "Ljava/lang/String;", "KEY_DISABLE_SPELL_CHECKER", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.edit.delegate.AIOEditTextInitializeVBDelegate$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AIOEditTextInitializeVBDelegate.f189456i.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/input/edit/delegate/AIOEditTextInitializeVBDelegate$b", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "", "onDestroyActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements ActionMode.Callback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEditTextInitializeVBDelegate.this);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@Nullable ActionMode mode, @Nullable MenuItem item) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) mode, (Object) item)).booleanValue();
            }
            boolean z18 = true;
            if (item != null && item.getItemId() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                HashMap hashMap = new HashMap();
                hashMap.put("longpress_menu_action_item", 1);
                com.tencent.mobileqq.aio.utils.b.l("em_bas_input_press_menu", hashMap);
                AIOEditTextInitializeVBDelegate.this.F(f.C7265f.f189532d);
                return true;
            }
            if (item != null && item.getItemId() == 3) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("longpress_menu_action_item", 1);
                com.tencent.mobileqq.aio.utils.b.l("em_bas_full_screen_press_menu", hashMap2);
                AIOEditTextInitializeVBDelegate.this.F(f.c.f189529d);
            } else {
                if (item == null || item.getItemId() != 4) {
                    z18 = false;
                }
                if (z18) {
                    AIOEditTextInitializeVBDelegate.this.F(f.d.f189530d);
                } else {
                    AIOEditTextInitializeVBDelegate.this.F(f.e.f189531d);
                }
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) mode, (Object) menu)).booleanValue();
            }
            if (menu != null) {
                AIOEditTextInitializeVBDelegate aIOEditTextInitializeVBDelegate = AIOEditTextInitializeVBDelegate.this;
                Context context = aIOEditTextInitializeVBDelegate.mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                    context = null;
                }
                aIOEditTextInitializeVBDelegate.F(new f.g(menu, context));
                return true;
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@Nullable ActionMode mode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) mode);
            } else {
                AIOEditTextInitializeVBDelegate.this.F(f.i.f189538d);
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@Nullable ActionMode mode, @Nullable Menu menu) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mode, (Object) menu)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/edit/delegate/AIOEditTextInitializeVBDelegate$c", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText$d;", "", "id", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements AIOEditText.d {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOEditText f189462b;

        c(AIOEditText aIOEditText) {
            this.f189462b = aIOEditText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOEditTextInitializeVBDelegate.this, (Object) aIOEditText);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.edit.AIOEditText.d
        public boolean a(int id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, id5)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOEditTextInitializeDelegate", 1, "[onTextContextMenuItem] id = " + id5 + " ");
            }
            if (id5 != 16908337) {
                switch (id5) {
                    case 16908320:
                    case 16908321:
                        AIOEditTextInitializeVBDelegate.this.u();
                        return false;
                    case 16908322:
                        break;
                    default:
                        return false;
                }
            }
            Editable text = this.f189462b.getText();
            Intrinsics.checkNotNull(text);
            int length = text.length();
            AIOEditText.Companion companion = AIOEditText.INSTANCE;
            if (length > companion.a()) {
                AIOEditTextInitializeVBDelegate.this.P();
                this.f189462b.setSelection(companion.a());
            }
            if (id5 == 16908322 && AIOEditTextInitializeVBDelegate.this.w()) {
                return true;
            }
            return this.f189462b.i(id5);
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AIOEditTextInitializeVBDelegate$Companion$KEY_EVENT_ENTERT_SWITCH$2.INSTANCE);
        f189456i = lazy;
    }

    public AIOEditTextInitializeVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
        } else {
            this.mHost = mHost;
        }
    }

    private final void A() {
        o();
        n();
        H();
        N();
        p();
        K();
        r();
    }

    private final boolean B() {
        return AIOInputUtil.f189159a.k();
    }

    private final void H() {
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            aIOEditText.setOnKeyEventPreImeListener(new AIOEditText.c() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.b
                @Override // com.tencent.mobileqq.aio.input.edit.AIOEditText.c
                public final boolean a(KeyEvent keyEvent) {
                    boolean I;
                    I = AIOEditTextInitializeVBDelegate.I(AIOEditTextInitializeVBDelegate.this, keyEvent);
                    return I;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I(AIOEditTextInitializeVBDelegate this$0, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f.b bVar = new f.b(keyEvent, false, 2, null);
        this$0.F(bVar);
        return bVar.b();
    }

    private final void K() {
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            aIOEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.c
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                    boolean L;
                    L = AIOEditTextInitializeVBDelegate.L(AIOEditTextInitializeVBDelegate.this, view, i3, keyEvent);
                    return L;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L(AIOEditTextInitializeVBDelegate this$0, View v3, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 66) {
            Intrinsics.checkNotNullExpressionValue(v3, "v");
            return this$0.v(v3);
        }
        return false;
    }

    private final void N() {
        final AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            Bundle inputExtras = aIOEditText.getInputExtras(true);
            if (inputExtras != null) {
                inputExtras.putInt(InputMethodUtil.FLAG_SOGOU_EXPRESSION, 1);
            }
            Bundle inputExtras2 = aIOEditText.getInputExtras(true);
            if (inputExtras2 != null) {
                inputExtras2.putInt(InputMethodUtil.SOGOU_EXPRESSION_WEBP, 1);
            }
            Bundle inputExtras3 = aIOEditText.getInputExtras(true);
            if (inputExtras3 != null) {
                inputExtras3.putInt(InputMethodUtil.SUPPORT_SOGOU_EXPRESSION, 1);
            }
            aIOEditText.setOnPrivateIMECommandListener(new AIOEditText.e() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.d
                @Override // com.tencent.mobileqq.aio.input.edit.AIOEditText.e
                public final boolean onPrivateIMECommand(String str, Bundle bundle) {
                    boolean O;
                    O = AIOEditTextInitializeVBDelegate.O(AIOEditTextInitializeVBDelegate.this, aIOEditText, str, bundle);
                    return O;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(AIOEditTextInitializeVBDelegate this$0, AIOEditText this_apply, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Context context = this$0.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        if (InputMethodUtil.checkSogouInputDefault(context)) {
            QLog.i("AIOEditTextInitializeDelegate", 1, "default input is sogou");
            this$0.F(new f.h(str, bundle, this_apply));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        Context context;
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null && (context = aIOEditText.getContext()) != null) {
            QQToast.makeText(context, R.string.c8h, 0).show();
        }
    }

    private final void n() {
        b bVar = new b();
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            aIOEditText.setCustomSelectionActionModeCallback(bVar);
        }
        AIOEditText aIOEditText2 = this.mEditText;
        if (aIOEditText2 != null) {
            aIOEditText2.setCustomInsertionActionModeCallback(bVar);
        }
    }

    private final void o() {
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText == null) {
            QLog.e("AIOEditTextInitializeDelegate", 1, "editText is null!");
        } else {
            aIOEditText.h(new c(aIOEditText));
        }
    }

    private final void p() {
        try {
            AIOEditText aIOEditText = this.mEditText;
            if (aIOEditText != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    aIOEditText.setImportantForAutofill(2);
                } else {
                    View.class.getMethod("setImportantForAutofill", Integer.TYPE).invoke(aIOEditText, 8);
                }
            }
        } catch (Throwable th5) {
            QLog.i("AIOEditTextInitializeDelegate", 1, "[disableAutoFill]", th5);
        }
    }

    private final void r() {
        if (!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_disable_spell_checker_9055_122960249", true)) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOEditTextInitializeDelegate", 2, "disableSpellChecker return, switch is off");
                return;
            }
            return;
        }
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            aIOEditText.setInputType(aIOEditText.getInputType() | 524288);
            if (QLog.isColorLevel()) {
                QLog.i("AIOEditTextInitializeDelegate", 1, "[disableSpellChecker]: inputType = " + aIOEditText.getInputType());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        if (!B()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOEditTextInitializeDelegate", 2, "handleCopyMenuClick return, switch is off");
                return;
            }
            return;
        }
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            AIOInputUtil.f189159a.s(aIOEditText.getEditableText(), Math.max(0, Math.min(aIOEditText.getSelectionStart(), aIOEditText.getSelectionEnd())), Math.max(0, Math.max(aIOEditText.getSelectionStart(), aIOEditText.getSelectionEnd())));
        }
    }

    private final boolean v(View view) {
        if (!INSTANCE.b()) {
            QLog.i("AIOEditTextInitializeDelegate", 1, "[handleKeyEnter]: switch off");
            return false;
        }
        if (!((IDevicesApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IDevicesApi.class)).isPadDevice() || view.getResources().getConfiguration().keyboard != 2) {
            return false;
        }
        F(f.a.f189526d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w() {
        if (!B()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOEditTextInitializeDelegate", 2, "handlePasteMenuClick return, switch is off");
            }
            return false;
        }
        CharSequence d16 = AIOInputUtil.f189159a.d();
        if (d16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOEditTextInitializeDelegate", 2, "handlePasteMenuClick return, pasteText is empty");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOEditTextInitializeDelegate", 2, "handlePasteMenuClick pasteText = " + ((Object) d16));
        }
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            aIOEditText.getEditableText().replace(Math.max(0, Math.min(aIOEditText.getSelectionStart(), aIOEditText.getSelectionEnd())), Math.max(0, Math.max(aIOEditText.getSelectionStart(), aIOEditText.getSelectionEnd())), d16);
            return true;
        }
        return true;
    }

    private final void y() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.input.edit.delegate.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOEditTextInitializeVBDelegate.z(AIOEditTextInitializeVBDelegate.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(AIOEditTextInitializeVBDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_disable_sougou_long_press_ptt_9060_116051201", true)) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOEditTextInitializeDelegate", 1, "initSougouPttConfigs return, switch is on");
                return;
            }
            return;
        }
        AIOEditText aIOEditText = this$0.mEditText;
        if (aIOEditText != null && aIOEditText.getInputExtras(true).getInt(InputMethodUtil.ARGS_KEY_CHANNELS) != 1) {
            RecordParams.RecorderParam recorderParam = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getRecorderParam();
            aIOEditText.getInputExtras(true).putBoolean(InputMethodUtil.ARGS_KEY_2SOGOU_SUPPORT_PTT, true);
            aIOEditText.getInputExtras(true).putInt(InputMethodUtil.ARGS_KEY_CHANNELS, 1);
            aIOEditText.getInputExtras(true).putInt(InputMethodUtil.ARGS_KEY_SAMPLE_RATE, recorderParam.f307255d);
            aIOEditText.getInputExtras(true).putInt(InputMethodUtil.ARGS_KEY_2SOGOU_TIME_LENGTH, 120);
            if (QLog.isColorLevel()) {
                QLog.d("AIOEditTextInitializeDelegate", 2, "initSougouPttConfigs params : sample = " + recorderParam.f307255d + " max = 120");
            }
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.b binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mEditText = binding.a();
        Context applicationContext = binding.getMContainer().getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "binding.root.context.applicationContext");
        this.mContext = applicationContext;
        A();
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            c.a.b(this);
            y();
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            H();
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bundle) iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
        }
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    public /* bridge */ /* synthetic */ List<Class<? extends InputUIState>> getObserverStates() {
        return (List) t();
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        c.a.d(this);
        AIOEditText aIOEditText = this.mEditText;
        if (aIOEditText != null) {
            aIOEditText.setOnKeyEventPreImeListener(null);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Nullable
    public Void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Void) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
        } else {
            Intrinsics.checkNotNullParameter(state, "state");
        }
    }
}
