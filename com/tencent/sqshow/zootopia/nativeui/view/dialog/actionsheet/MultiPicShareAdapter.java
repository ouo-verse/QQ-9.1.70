package com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanShareItem;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import n74.bg;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/MultiPicShareAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/MultiPicShareAdapter$b;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/s;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "j0", "Lcom/tencent/sqshow/utils/featureswitch/model/aj;", "Landroid/graphics/drawable/Drawable;", "l0", "", "url", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "getItemCount", "holder", "position", "n0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/ConcurrentHashMap;", "qrCodeImageMap", "<init>", "(Ljava/util/List;)V", "D", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MultiPicShareAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final ConcurrentHashMap<String, Bitmap> qrCodeImageMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<PicShareData> data;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/actionsheet/MultiPicShareAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ln74/bg;", "E", "Ln74/bg;", "l", "()Ln74/bg;", "binding", "<init>", "(Ln74/bg;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final bg binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bg binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        }

        /* renamed from: l, reason: from getter */
        public final bg getBinding() {
            return this.binding;
        }
    }

    public MultiPicShareAdapter(List<PicShareData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.qrCodeImageMap = new ConcurrentHashMap<>();
    }

    private final void j0(final PicShareData item) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.q
            @Override // java.lang.Runnable
            public final void run() {
                MultiPicShareAdapter.k0(PicShareData.this, this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, android.graphics.Bitmap] */
    public static final void k0(final PicShareData item, final MultiPicShareAdapter this$0) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String qrForegroundColor = item.getConfig().getQrForegroundColor();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r26 = this$0.qrCodeImageMap.get(qrForegroundColor);
        objectRef.element = r26;
        if (r26 == 0) {
            ?? i3 = t.i(MobileQQ.sMobileQQ.getApplicationContext(), u.f().i("https://ti.qq.com/new_open_qq/index.html?appid=40&url=mqqapi%3A%2F%2Fzplan%2FenterAvatarScene%3Fsrc_type%3Dapp%26version%3D1.0%26subReferer%3Dzplan_entrance_store_share_qrcode%26sceneType%3D1%26sceneData%3D%257B%2522SubScene%2522%253A%257B%2522SceneType%2522%253A1%257D%257D").h(com.tencent.sqshow.zootopia.utils.i.b(AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE)).f(Color.parseColor(qrForegroundColor)).e());
            objectRef.element = i3;
            if (i3 != 0 && !this$0.qrCodeImageMap.containsKey(qrForegroundColor)) {
                this$0.qrCodeImageMap.put(qrForegroundColor, objectRef.element);
            }
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.MultiPicShareAdapter$generateQRCode$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Bitmap bitmap = objectRef.element;
                if (bitmap != null) {
                    item.g(bitmap);
                    this$0.notifyDataSetChanged();
                } else {
                    QLog.e("MultiPicShareAdapter", 1, "generateQRCode but qrcode is null");
                }
            }
        });
    }

    private final Drawable l0(ZPlanShareItem item) {
        int collectionSizeOrDefault;
        int[] intArray;
        if (item.e().isEmpty()) {
            Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
            Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
            return TRANSPARENT;
        }
        if (item.e().size() == 1) {
            return new ColorDrawable(Color.parseColor(item.e().get(0)));
        }
        List<String> e16 = item.e();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = e16.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Color.parseColor((String) it.next())));
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArray);
        gradientDrawable.setGradientType(0);
        return gradientDrawable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        String d16;
        String replace$default;
        Intrinsics.checkNotNullParameter(holder, "holder");
        PicShareData picShareData = this.data.get(position);
        bg binding = holder.getBinding();
        try {
            TextView textView = binding.f418829e;
            String desc = picShareData.getConfig().getDesc();
            d16 = r.d();
            replace$default = StringsKt__StringsJVMKt.replace$default(desc, "{nick}", d16, false, 4, (Object) null);
            textView.setText(replace$default);
            binding.f418830f.setText(picShareData.getTime());
            if (picShareData.getAvatarDrawable() != null) {
                binding.f418826b.setImageDrawable(picShareData.getAvatarDrawable());
                binding.f418831g.g();
                binding.f418831g.setVisibility(8);
            } else {
                binding.f418831g.setVisibility(0);
                binding.f418831g.f();
            }
            if (picShareData.getQrCodeBitmap() != null) {
                binding.f418832h.setImageBitmap(picShareData.getQrCodeBitmap());
            } else {
                j0(picShareData);
            }
            binding.f418827c.setBackgroundDrawable(m0(picShareData.getConfig().getBackgroundUrl()));
            String fontColor = picShareData.getConfig().getFontColor();
            binding.f418829e.setTextColor(Color.parseColor(fontColor));
            binding.f418830f.setTextColor(Color.parseColor(fontColor));
            binding.f418828d.setBackground(l0(picShareData.getConfig()));
            binding.f418833i.setBackground(new ColorDrawable(Color.parseColor(picShareData.getConfig().getQrBackgroundColor())));
        } catch (Throwable th5) {
            QLog.e("MultiPicShareAdapter", 1, "wrong config: t:" + th5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bg g16 = bg.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        return new b(g16);
    }

    private final Drawable m0(String url) {
        URLDrawable fileDrawable;
        if (url == null || url.length() == 0) {
            Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
            Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
            return TRANSPARENT;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable TRANSPARENT2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = TRANSPARENT2;
        obtain.mFailedDrawable = TRANSPARENT2;
        if (URLUtil.isValidUrl(url)) {
            fileDrawable = URLDrawable.getDrawable(url, obtain);
        } else {
            fileDrawable = URLDrawable.getFileDrawable(url, obtain);
        }
        if (fileDrawable != null) {
            return fileDrawable;
        }
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT2, "TRANSPARENT");
        return TRANSPARENT2;
    }
}
