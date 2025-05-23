package com.qzone.reborn.albumx.qzonex.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.qzonex.widget.OverlappingImgLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0003=>\u0003B\u0013\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u00a2\u0006\u0004\b5\u00106B\u001d\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00108\u001a\u0004\u0018\u000107\u00a2\u0006\u0004\b5\u00109B%\b\u0016\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00108\u001a\u0004\u0018\u000107\u0012\u0006\u0010:\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0013\u00102\u001a\u0004\u0018\u00010\u001f8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u00101\u00a8\u0006?"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout;", "Landroid/widget/LinearLayout;", "", "c", "", "type", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$b;", "imgBean", "Landroid/graphics/drawable/Drawable;", "e", "", "uin", "Landroid/graphics/Bitmap;", "f", "g", "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$c;", "options", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "I", "mChildHeight", "mChildWidth", "overlappings", "", "Landroid/widget/ImageView;", h.F, "Ljava/util/List;", "imgs", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mFaceDecoder", "mGetFaceType", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$c;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "D", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "getMDecodeTaskCompletionListener", "()Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "setMDecodeTaskCompletionListener", "(Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;)V", "mDecodeTaskCompletionListener", "", "j", "()Z", MiniGamePAHippyBaseFragment.KEY_THEME, "()Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "faceDecoder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class OverlappingImgLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private c options;

    /* renamed from: D, reason: from kotlin metadata */
    private DecodeTaskCompletionListener mDecodeTaskCompletionListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mChildHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mChildWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int overlappings;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<ImageView> imgs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IFaceDecoder mFaceDecoder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mGetFaceType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "uin", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "c", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String uin = "";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Drawable drawable;

        /* renamed from: a, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* renamed from: b, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public final void c(Drawable drawable) {
            this.drawable = drawable;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u0003\u0010\u0010\"\u0004\b \u0010\u0012R(\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010$\u001a\u0004\b\u0014\u0010%\"\u0004\b&\u0010'RA\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u00010#\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010.\u001a\u0004\b\u001f\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$c;", "", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "i", "(F)V", "childHeight", "c", "j", "childWidth", "", "I", "g", "()I", "o", "(I)V", "overlappings", "d", "e", "l", "maxNum", "", "Z", h.F, "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "isNeedNightMode", "f", "setChildBorderSize", "childBorderSize", "", "Lcom/qzone/reborn/albumx/qzonex/widget/OverlappingImgLayout$b;", "Ljava/util/List;", "()Ljava/util/List;", "k", "(Ljava/util/List;)V", "imgBeans", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", DomainData.DOMAIN_NAME, "(Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float childHeight;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float childWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int overlappings = ViewUtils.dip2px(4.0f);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int maxNum = 3;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isNeedNightMode = true;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int childBorderSize = ViewUtils.dip2px(1.0f);

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private List<b> imgBeans = new ArrayList();

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private Function1<? super b, Unit> onItemClickListener;

        /* renamed from: a, reason: from getter */
        public final int getChildBorderSize() {
            return this.childBorderSize;
        }

        /* renamed from: b, reason: from getter */
        public final float getChildHeight() {
            return this.childHeight;
        }

        /* renamed from: c, reason: from getter */
        public final float getChildWidth() {
            return this.childWidth;
        }

        public final List<b> d() {
            return this.imgBeans;
        }

        /* renamed from: e, reason: from getter */
        public final int getMaxNum() {
            return this.maxNum;
        }

        public final Function1<b, Unit> f() {
            return this.onItemClickListener;
        }

        /* renamed from: g, reason: from getter */
        public final int getOverlappings() {
            return this.overlappings;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getIsNeedNightMode() {
            return this.isNeedNightMode;
        }

        public final void i(float f16) {
            this.childHeight = f16;
        }

        public final void j(float f16) {
            this.childWidth = f16;
        }

        public final void k(List<b> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.imgBeans = list;
        }

        public final void l(int i3) {
            this.maxNum = i3;
        }

        public final void m(boolean z16) {
            this.isNeedNightMode = z16;
        }

        public final void n(Function1<? super b, Unit> function1) {
            this.onItemClickListener = function1;
        }

        public final void o(int i3) {
            this.overlappings = i3;
        }
    }

    public OverlappingImgLayout(Context context) {
        super(context);
        this.imgs = new ArrayList();
        this.mGetFaceType = 1;
        this.mDecodeTaskCompletionListener = new DecodeTaskCompletionListener() { // from class: rc.b
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                OverlappingImgLayout.k(OverlappingImgLayout.this, i3, i16, str, bitmap);
            }
        };
    }

    private final void c() {
        removeAllViews();
        if (this.imgs.size() == 0) {
            return;
        }
        int size = this.imgs.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            View view = (ImageView) this.imgs.get(i16);
            c cVar = this.options;
            int childBorderSize = cVar != null ? cVar.getChildBorderSize() : 0;
            view.setPadding(childBorderSize, childBorderSize, childBorderSize, childBorderSize);
            if (!j()) {
                view.setBackgroundResource(R.drawable.aaa);
            } else {
                view.setBackgroundResource(R.drawable.hjr);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mChildWidth, this.mChildHeight);
            layoutParams.setMargins(i3 * (-1), 0, 0, 0);
            view.setLayoutParams(layoutParams);
            view.setOnClickListener(new View.OnClickListener() { // from class: rc.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OverlappingImgLayout.d(OverlappingImgLayout.this, view2);
                }
            });
            view.setTag(Integer.valueOf(i16));
            addView(view);
            i3 = this.overlappings;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(OverlappingImgLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.options;
        if (cVar != null) {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) tag).intValue();
            b bVar = intValue < cVar.d().size() ? cVar.d().get(intValue) : null;
            Function1<b, Unit> f16 = cVar.f();
            if (f16 != null) {
                f16.invoke(bVar);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final Drawable e(b imgBean, int type) {
        Bitmap f16;
        if (imgBean.getDrawable() != null) {
            return imgBean.getDrawable();
        }
        String uin = imgBean.getUin();
        if ((uin == null || uin.length() == 0) || (f16 = f(imgBean.getUin(), type)) == null) {
            return null;
        }
        return new BitmapDrawable(getContext().getResources(), f16);
    }

    private final Bitmap g(String uin) {
        IFaceDecoder iFaceDecoder = this.mFaceDecoder;
        if (iFaceDecoder == null) {
            if (QLog.isColorLevel()) {
                QLog.i("OverlappingImgLayout", 2, "mFaceDecoder null");
            }
            return null;
        }
        Intrinsics.checkNotNull(iFaceDecoder);
        Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(1, uin, 0, (byte) 4);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        IFaceDecoder iFaceDecoder2 = this.mFaceDecoder;
        Intrinsics.checkNotNull(iFaceDecoder2);
        if (iFaceDecoder2.isPausing()) {
            return null;
        }
        IFaceDecoder iFaceDecoder3 = this.mFaceDecoder;
        Intrinsics.checkNotNull(iFaceDecoder3);
        iFaceDecoder3.requestDecodeFace(uin, 200, false, 1, true, (byte) 0, 4);
        return null;
    }

    private final boolean j() {
        c cVar = this.options;
        return !(cVar != null && !cVar.getIsNeedNightMode()) && (Intrinsics.areEqual("1103", ThemeUtil.curThemeId) || Intrinsics.areEqual("2920", ThemeUtil.curThemeId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(OverlappingImgLayout this$0, int i3, int i16, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(str) || bitmap == null) {
            return;
        }
        c cVar = this$0.options;
        if ((cVar != null ? cVar.d() : null) == null) {
            return;
        }
        c cVar2 = this$0.options;
        Intrinsics.checkNotNull(cVar2);
        int size = cVar2.d().size();
        for (int i17 = 0; i17 < size; i17++) {
            c cVar3 = this$0.options;
            Intrinsics.checkNotNull(cVar3);
            if (i17 < cVar3.getMaxNum()) {
                c cVar4 = this$0.options;
                Intrinsics.checkNotNull(cVar4);
                if (Intrinsics.areEqual(str, cVar4.d().get(i17).getUin())) {
                    this$0.imgs.get(i17).setImageDrawable(new BitmapDrawable(this$0.getContext().getResources(), bitmap));
                    if (QLog.isColorLevel()) {
                        QLog.d("OverlappingImgLayout", 2, "mDecodeTaskCompletionListener update");
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("OverlappingImgLayout", 2, "onDecodeTaskCompleted, uin: " + str + ", type: " + i16);
        }
    }

    private final void n(int type) {
        ImageView imageView;
        List<b> d16;
        this.imgs.clear();
        c cVar = this.options;
        if (cVar != null) {
            if ((cVar == null || (d16 = cVar.d()) == null || !d16.isEmpty()) ? false : true) {
                return;
            }
            c cVar2 = this.options;
            Intrinsics.checkNotNull(cVar2);
            int size = cVar2.d().size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar3 = this.options;
                Intrinsics.checkNotNull(cVar3);
                if (i3 >= cVar3.getMaxNum()) {
                    return;
                }
                c cVar4 = this.options;
                if (cVar4 != null && cVar4.getIsNeedNightMode()) {
                    imageView = new ThemeImageView(getContext());
                } else {
                    imageView = new ImageView(getContext());
                }
                c cVar5 = this.options;
                Intrinsics.checkNotNull(cVar5);
                imageView.setImageDrawable(e(cVar5.d().get(i3), type));
                this.imgs.add(imageView);
            }
        }
    }

    public final IFaceDecoder h() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d("OverlappingImgLayout", 2, "getFaceDecoder app null");
            return null;
        }
        return ((IQQAvatarService) peekAppRuntime.getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) peekAppRuntime);
    }

    public final void i(c options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        this.mChildHeight = ViewUtils.dip2px(options.getChildHeight());
        this.mChildWidth = ViewUtils.dip2px(options.getChildWidth());
        this.overlappings = options.getOverlappings();
        setOrientation(0);
        IFaceDecoder h16 = h();
        this.mFaceDecoder = h16;
        if (h16 != null) {
            Intrinsics.checkNotNull(h16);
            h16.setDecodeTaskCompletionListener(this.mDecodeTaskCompletionListener);
        }
        this.mGetFaceType = 1;
        l();
    }

    public final void l() {
        n(this.mGetFaceType);
        c();
    }

    public final void m() {
        IFaceDecoder h16 = h();
        if (h16 != null) {
            h16.destory();
        }
    }

    public final void setMDecodeTaskCompletionListener(DecodeTaskCompletionListener decodeTaskCompletionListener) {
        Intrinsics.checkNotNullParameter(decodeTaskCompletionListener, "<set-?>");
        this.mDecodeTaskCompletionListener = decodeTaskCompletionListener;
    }

    private final Bitmap f(String uin, int type) {
        if (type == 1) {
            return g(uin);
        }
        return null;
    }

    public OverlappingImgLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.imgs = new ArrayList();
        this.mGetFaceType = 1;
        this.mDecodeTaskCompletionListener = new DecodeTaskCompletionListener() { // from class: rc.b
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                OverlappingImgLayout.k(OverlappingImgLayout.this, i3, i16, str, bitmap);
            }
        };
    }

    public OverlappingImgLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.imgs = new ArrayList();
        this.mGetFaceType = 1;
        this.mDecodeTaskCompletionListener = new DecodeTaskCompletionListener() { // from class: rc.b
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i36, int i16, String str, Bitmap bitmap) {
                OverlappingImgLayout.k(OverlappingImgLayout.this, i36, i16, str, bitmap);
            }
        };
    }
}
