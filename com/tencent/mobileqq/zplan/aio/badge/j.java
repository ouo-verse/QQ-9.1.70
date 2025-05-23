package com.tencent.mobileqq.zplan.aio.badge;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.utils.l;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020\u001a\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\nJ,\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/j;", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "Lcom/tencent/mobileqq/zplan/aio/badge/a;", "data", "Landroid/view/View;", "c", "Landroid/widget/ImageView;", "view", "", "uin", "", "b", "", "index", "d", "a", "e", "remainingTasks", "type", "Landroid/graphics/Bitmap;", "avatar", "onDecodeTaskCompleted", "Lcom/tencent/mobileqq/zplan/aio/badge/a;", "Lcom/tencent/mobileqq/vas/social/config/g;", "Lcom/tencent/mobileqq/vas/social/config/g;", "faceDecoder", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "f", "Landroid/content/Context;", "appContext", tl.h.F, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/zplan/aio/badge/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j implements IDecodeTaskCompletionListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.vas.social.config.g faceDecoder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Context appContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    public j(Context context, a data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.appContext = context.getApplicationContext();
    }

    private final void b(ImageView view, String uin) {
        com.tencent.mobileqq.vas.social.config.g gVar = this.faceDecoder;
        if (gVar == null) {
            return;
        }
        Bitmap bitmapFromCache$default = gVar != null ? IFaceDecoder.DefaultImpls.getBitmapFromCache$default(gVar, uin, false, 2, null) : null;
        if (bitmapFromCache$default != null) {
            l.c(view, true);
            view.setImageBitmap(bitmapFromCache$default);
        } else {
            gVar.setDecodeTaskCompletionListener(this);
            IFaceDecoder.DefaultImpls.requestDecodeFace$default(gVar, uin, false, 2, null);
        }
    }

    private final View c(a data) {
        LayoutInflater from = LayoutInflater.from(this.appContext);
        int size = data.c().size();
        if (size == 1) {
            LinearLayout root = fi3.c.g(from).getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater).root");
            return root;
        }
        if (size != 2) {
            LinearLayout root2 = fi3.e.g(from).getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "inflate(inflater).root");
            return root2;
        }
        LinearLayout root3 = fi3.d.g(from).getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "inflate(inflater).root");
        return root3;
    }

    public final View a() {
        View c16 = c(this.data);
        TextView textView = (TextView) c16.findViewById(R.id.f163556qr4);
        if (textView != null) {
            textView.setText(this.data.getText());
        }
        if (!this.data.c().isEmpty()) {
            this.faceDecoder = new com.tencent.mobileqq.vas.social.config.g();
            int i3 = 0;
            for (Object obj : this.data.c()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                long longValue = ((Number) obj).longValue();
                ImageView d16 = d(i3, c16);
                if (d16 != null) {
                    b(d16, String.valueOf(longValue));
                }
                i3 = i16;
            }
        }
        this.rootView = c16;
        return c16;
    }

    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
        Long longOrNull;
        int indexOf;
        ImageView d16;
        View view = this.rootView;
        if (view == null || uin == null) {
            return;
        }
        List<Long> c16 = this.data.c();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uin);
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends Long>) ((List<? extends Object>) c16), longOrNull);
        if (indexOf < 0 || (d16 = d(indexOf, view)) == null) {
            return;
        }
        b(d16, uin);
    }

    public final void e() {
        this.rootView = null;
        com.tencent.mobileqq.vas.social.config.g gVar = this.faceDecoder;
        if (gVar != null) {
            gVar.destroy();
        }
        this.faceDecoder = null;
    }

    private final ImageView d(int index, View view) {
        if (index == 0) {
            return (ImageView) view.findViewById(R.id.pbe);
        }
        if (index == 1) {
            return (ImageView) view.findViewById(R.id.pbf);
        }
        if (index != 2) {
            return null;
        }
        return (ImageView) view.findViewById(R.id.pbg);
    }
}
