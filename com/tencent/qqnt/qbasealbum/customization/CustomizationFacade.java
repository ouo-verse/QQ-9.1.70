package com.tencent.qqnt.qbasealbum.customization;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/CustomizationFacade;", "", "Landroid/content/Intent;", "intent", "", "d", "Landroid/content/Context;", "context", "f", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "e", "Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "b", "()Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "pickerCustomize", "Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "c", "()Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "previewCustomize", "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "a", "()Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CustomizationFacade {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CustomizationFacade f361084a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35832);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f361084a = new CustomizationFacade();
        }
    }

    CustomizationFacade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a() {
        b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = b();
        if (b16 == null || (photoCommonData = b16.getPhotoCommonData()) == null) {
            AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = c();
            if (c16 != null) {
                return c16.getPhotoCommonData();
            }
            return null;
        }
        return photoCommonData;
    }

    @Nullable
    public final AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbstractPickerLogic) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> j3 = QAlbumPickerContext.f361201a.j();
        if (j3 == null) {
            ox3.a.e("QBaseAlbum.Customization", CustomizationFacade$pickerCustomize$1.INSTANCE);
        }
        return j3;
    }

    @Nullable
    public final AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AbstractPreviewLogic) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> k3 = QAlbumPickerContext.f361201a.k();
        if (k3 == null) {
            ox3.a.e("QBaseAlbum.Customization", CustomizationFacade$previewCustomize$1.INSTANCE);
        }
        return k3;
    }

    public final void d(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = b();
        if (b16 != null) {
            b16.initData(intent);
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = c();
        if (c16 != null) {
            c16.initData(intent);
        }
    }

    public final void e(final int requestCode, final int resultCode, @Nullable final Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        ox3.a.c("QBaseAlbum.Customization", new Function0<String>(requestCode, resultCode, data) { // from class: com.tencent.qqnt.qbasealbum.customization.CustomizationFacade$onActivityResult$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Intent $data;
            final /* synthetic */ int $requestCode;
            final /* synthetic */ int $resultCode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$requestCode = requestCode;
                this.$resultCode = resultCode;
                this.$data = data;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onActivityResult requestCode:" + this.$requestCode + " resultCode:" + this.$resultCode + " " + (this.$data != null);
            }
        });
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = b();
        if (b16 != null) {
            b16.onActivityResult(requestCode, resultCode, data);
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = c();
        if (c16 != null) {
            c16.onActivityResult(requestCode, resultCode, data);
        }
    }

    public final void f(@Nullable final Intent intent, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ox3.a.c("QBaseAlbum.Customization", new Function0<String>(intent) { // from class: com.tencent.qqnt.qbasealbum.customization.CustomizationFacade$onNewIntent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Intent $intent;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$intent = intent;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) intent);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onNewIntent " + (this.$intent != null);
            }
        });
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = b();
        if (b16 != null) {
            b16.onNewIntent(intent, context);
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> c16 = c();
        if (c16 != null) {
            c16.onNewIntent(intent);
        }
    }
}
