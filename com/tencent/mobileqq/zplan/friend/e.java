package com.tencent.mobileqq.zplan.friend;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002J&\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u001e\u0010\u001b\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/e;", "Lcom/tencent/mobileqq/armap/e;", "Lcom/tencent/mobileqq/zplan/friend/a;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "f", "", "url", "g", "b", "d", "Lcom/tencent/mobileqq/zplan/friend/c;", "friendInfo", "holder", "c", "uin", "headPath", "head", tl.h.F, "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/armap/f;", "kotlin.jvm.PlatformType", "e", "Lcom/tencent/mobileqq/armap/f;", "faceDecoder", "", "Ljava/util/Map;", "holderMap", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e implements com.tencent.mobileqq.armap.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.armap.f faceDecoder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<a, String> holderMap;

    public e(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.handler = new Handler(Looper.getMainLooper());
        com.tencent.mobileqq.armap.f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(app.getApplicationContext(), 1);
        nonMainAppHeadLoader.init();
        this.faceDecoder = nonMainAppHeadLoader;
        this.holderMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList arrayList = new ArrayList();
        for (a aVar : this$0.holderMap.keySet()) {
            if (Intrinsics.areEqual(str, this$0.holderMap.get(aVar))) {
                arrayList.add(aVar);
                this$0.f(aVar, bitmap);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this$0.holderMap.remove((a) it.next());
        }
    }

    private final void f(a aVar, Bitmap bitmap) {
        ImageView avatar = aVar.getAvatar();
        if (avatar != null) {
            avatar.setImageDrawable(new BitmapDrawable(aVar.itemView.getResources(), bitmap));
        }
    }

    private final void g(a aVar, String str) {
        ImageView avatar = aVar.getAvatar();
        if (avatar != null) {
            avatar.setImageDrawable(URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain()));
        }
    }

    public final void b() {
        this.faceDecoder.a(this);
    }

    public final void c(FriendInfo friendInfo, a holder) {
        Intrinsics.checkNotNullParameter(friendInfo, "friendInfo");
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView name = holder.getName();
        if (name != null) {
            name.setText(friendInfo.getName());
        }
        String head = friendInfo.getHead();
        if (head == null || head.length() == 0) {
            Bitmap d16 = this.faceDecoder.d(friendInfo.getUin(), true, null);
            Bitmap defaultFaceBitmap = d16 == null ? BaseImageUtil.getDefaultFaceBitmap() : d16;
            Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "avatarImage ?: BaseImage\u2026il.getDefaultFaceBitmap()");
            f(holder, defaultFaceBitmap);
            if (d16 != null) {
                this.holderMap.remove(holder);
                return;
            } else {
                this.holderMap.put(holder, friendInfo.getUin());
                return;
            }
        }
        g(holder, friendInfo.getHead());
    }

    public final void d() {
        this.holderMap.clear();
        this.faceDecoder.f(this);
    }

    @Override // com.tencent.mobileqq.armap.e
    public void h(final String uin, String headPath, final Bitmap head) {
        if (head == null || uin == null) {
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.friend.d
            @Override // java.lang.Runnable
            public final void run() {
                e.e(e.this, uin, head);
            }
        });
    }
}
