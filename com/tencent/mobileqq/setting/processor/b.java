package com.tencent.mobileqq.setting.processor;

import android.content.Intent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u0012\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/setting/processor/b;", "Lcom/tencent/mobileqq/setting/processor/d;", "", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "d", "g", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "f", "", "Lcom/tencent/mobileqq/setting/processor/c;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "itemProcessors", "", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "topTitle", "bottomTitle", "<init>", "(Ljava/util/List;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class b implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> itemProcessors;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence topTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence bottomTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull List<? extends c> itemProcessors, @NotNull CharSequence topTitle, @NotNull CharSequence bottomTitle) {
        Intrinsics.checkNotNullParameter(itemProcessors, "itemProcessors");
        Intrinsics.checkNotNullParameter(topTitle, "topTitle");
        Intrinsics.checkNotNullParameter(bottomTitle, "bottomTitle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, itemProcessors, topTitle, bottomTitle);
            return;
        }
        this.itemProcessors = itemProcessors;
        this.topTitle = topTitle;
        this.bottomTitle = bottomTitle;
    }

    @NotNull
    public final CharSequence a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.bottomTitle;
    }

    @NotNull
    public final List<c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.itemProcessors;
    }

    @NotNull
    public final CharSequence c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.topTitle;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).n();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).o();
        }
    }

    public void f(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).p(requestCode, resultCode, data);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).r();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onCreate();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onPause();
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<T> it = this.itemProcessors.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onResume();
        }
    }

    public /* synthetic */ b(List list, CharSequence charSequence, CharSequence charSequence2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? "" : charSequence, (i3 & 4) == 0 ? charSequence2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, charSequence, charSequence2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
