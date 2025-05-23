package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.AddContactGroupViewHolder;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.o;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "Landroid/view/ViewGroup;", "viewGroup", "", "i", "", "uin", "", "type", "a", "Landroid/graphics/Bitmap;", "e", "remainingTasks", "avatar", "onDecodeTaskCompleted", "b", "groupUin", "Landroid/graphics/drawable/Drawable;", "g", "Landroid/content/Context;", "context", "headUrl", h.F, "d", "f", "c", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "attachListView", "Ljava/util/Hashtable;", "Ljava/util/Hashtable;", "faceCache", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "faceDecoder", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroidx/recyclerview/widget/RecyclerView;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQAppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView attachListView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Hashtable<String, Bitmap> faceCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IFaceDecoder faceDecoder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull QQAppInterface app, @NotNull RecyclerView attachListView) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(attachListView, "attachListView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app, (Object) attachListView);
            return;
        }
        this.app = app;
        this.attachListView = attachListView;
        this.faceCache = new Hashtable<>();
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) app.getRuntimeService(IQQAvatarService.class, "")).getInstance(app);
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        Intrinsics.checkNotNullExpressionValue(iQQAvatarService, "app.getRuntimeService(IQ\u2026nListener(this)\n        }");
        this.faceDecoder = iQQAvatarService;
    }

    private final void a(String uin, int type) {
        if (this.faceDecoder.isPausing()) {
            QLog.e("AddContactLoadAvatarDelegate", 1, "faceDecoder is pausing, avatar might skipped. uin: " + uin + ", type: " + type);
            return;
        }
        this.faceDecoder.requestDecodeFace(uin, type, true, (byte) 0);
    }

    private final Bitmap e() {
        Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
        Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "getDefaultFaceBitmap()");
        return defaultFaceBitmap;
    }

    private final void i(ViewGroup viewGroup) {
        boolean z16;
        Bitmap bitmap;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "viewGroup.getChildAt(i)");
            Object tag = childAt.getTag();
            if (tag instanceof o) {
                o oVar = (o) tag;
                boolean z17 = true;
                if (oVar.e0().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    Bitmap bitmap2 = this.faceCache.get(oVar.e0());
                    if (bitmap2 != null) {
                        oVar.f0().setImageBitmap(bitmap2);
                    }
                }
                if (oVar.k0().length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    ImageView imageView = (ImageView) oVar.m0().findViewById(R.id.dvo);
                    if (imageView != null && (bitmap = this.faceCache.get(oVar.k0())) != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            }
            if (tag instanceof AddContactGroupViewHolder) {
                i(((AddContactGroupViewHolder) tag).r());
            }
        }
    }

    @NotNull
    public final Bitmap b(@NotNull String uin, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin, type);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        String c16 = c(uin, type);
        Bitmap bitmap = this.faceCache.get(c16);
        if (bitmap == null) {
            bitmap = this.faceDecoder.getBitmapFromCache(type, uin);
        }
        if (bitmap != null) {
            this.faceCache.put(c16, bitmap);
            return bitmap;
        }
        QLog.i("AddContactLoadAvatarDelegate", 2, "getCacheBitmap not match. uin: " + uin + ", type: " + type);
        a(uin, type);
        return e();
    }

    @NotNull
    public final String c(@NotNull String uin, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) uin, type);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return uin + "_" + type;
    }

    @NotNull
    public final Drawable d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
        Intrinsics.checkNotNullExpressionValue(defaultFaceDrawable, "getDefaultFaceDrawable()");
        return defaultFaceDrawable;
    }

    @NotNull
    public final Drawable f(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new ColorDrawable(ContextCompat.getColor(context, R.color.qui_common_fill_standard_primary));
    }

    @NotNull
    public final Drawable g(@NotNull String groupUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupUin);
        }
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(this.app, 4, groupUin);
        Intrinsics.checkNotNullExpressionValue(faceDrawable, "getFaceDrawable(app, Fac\u2026EAD_TYPE_GROUP, groupUin)");
        return faceDrawable;
    }

    @NotNull
    public final Drawable h(@NotNull Context context, @NotNull String headUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) headUrl);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        Drawable d16 = d();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int c16 = x.c(context, 58.0f);
        int c17 = x.c(context, 29.0f);
        obtain.mRequestWidth = c16;
        obtain.mRequestHeight = c16;
        obtain.mFailedDrawable = d16;
        obtain.mLoadingDrawable = d16;
        if (URLUtil.isValidUrl(headUrl)) {
            URLDrawable urlDrawable = URLDrawable.getDrawable(headUrl, obtain);
            urlDrawable.setTag(new int[]{c16, c16, c17});
            urlDrawable.setDecodeHandler(RecommendTroopAdapter.f293757m);
            if (urlDrawable.getStatus() != 1 && urlDrawable.getStatus() != 0) {
                urlDrawable.restartDownload();
            }
            Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
            return urlDrawable;
        }
        return d16;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(remainingTasks), Integer.valueOf(type), uin, avatar);
            return;
        }
        if (this.faceDecoder.isPausing()) {
            return;
        }
        if (avatar != null && uin != null) {
            this.faceCache.put(c(uin, type), avatar);
        }
        if (remainingTasks > 0) {
            return;
        }
        i(this.attachListView);
        this.faceCache.clear();
    }
}
