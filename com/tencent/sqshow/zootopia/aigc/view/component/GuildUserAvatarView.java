package com.tencent.sqshow.zootopia.aigc.view.component;

import android.content.Context;
import android.graphics.Outline;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.aigc.view.component.GuildUserAvatarView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 J2\u00020\u0001:\u0002KLB%\b\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u0012\u0006\u0010E\u001a\u00020\u0005\u00a2\u0006\u0004\bF\u0010GB\u001d\b\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\b\u0010D\u001a\u0004\u0018\u00010C\u00a2\u0006\u0004\bF\u0010HB\u0013\b\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u00a2\u0006\u0004\bF\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0014J(\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0014J\b\u0010#\u001a\u00020\u0002H\u0014J\b\u0010$\u001a\u00020\u0002H\u0014J\u001a\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010&H\u0016R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010(R$\u0010\u000e\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010(R\u0016\u00101\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\"\u0010:\u001a\u00020\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b5\u00103\u001a\u0004\b6\u00107\"\u0004\b8\u00109R0\u0010?\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050;j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00103\u00a8\u0006M"}, d2 = {"Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView;", "Landroid/widget/ImageView;", "", "d", "e", "", "width", "b", "", "from", "f", "loadType", "setLoadType", "guildId", "tinyId", "setAvatarTinyId", "avatarMeta", "setAvatarMeta", "needSize", "setAvatarSize", "tag", "setLogTag", "radius", "setRoundRect", "", "needListenChange", "setNeedListenChange", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "key", "", "setTag", "Ljava/lang/String;", "mTag", "mGuildId", "<set-?>", "getTinyId", "()Ljava/lang/String;", "mAvatarMeta", "i", "Z", "mNeedListenChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mNeedSize", BdhLogUtil.LogTag.Tag_Conn, "c", "()I", "setMRoundRectRadius", "(I)V", "mRoundRectRadius", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "D", "Ljava/util/LinkedHashMap;", "mAvatarSizeMap", "E", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "LoadType", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class GuildUserAvatarView extends ImageView {
    private static final String G = "GuildUserAvatarView.";

    /* renamed from: C, reason: from kotlin metadata */
    private int mRoundRectRadius;

    /* renamed from: D, reason: from kotlin metadata */
    private final LinkedHashMap<Integer, Integer> mAvatarSizeMap;

    /* renamed from: E, reason: from kotlin metadata */
    private int loadType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mGuildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String tinyId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mAvatarMeta;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedListenChange;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mNeedSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView$LoadType;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes34.dex */
    public @interface LoadType {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f369920a;
        public static final int LOAD_BY_META = 2;
        public static final int LOAD_BY_TINYID = 0;
        public static final int LOAD_BY_URL = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView$LoadType$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.aigc.view.component.GuildUserAvatarView$LoadType$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f369920a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/aigc/view/component/GuildUserAvatarView$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int mRoundRectRadius;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            if (GuildUserAvatarView.this.getMRoundRectRadius() < 0) {
                mRoundRectRadius = view.getWidth() / 2;
            } else {
                mRoundRectRadius = GuildUserAvatarView.this.getMRoundRectRadius();
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), mRoundRectRadius);
        }
    }

    public GuildUserAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mTag = "GuildUserAvatarView";
        this.mGuildId = "0";
        this.tinyId = "";
        this.mAvatarMeta = "";
        this.mNeedListenChange = true;
        this.mNeedSize = -1;
        this.mRoundRectRadius = -1;
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.loadType = 1;
        d();
    }

    private final int b(int width) {
        for (Map.Entry<Integer, Integer> entry : this.mAvatarSizeMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if (width < intValue) {
                return intValue2;
            }
        }
        return 2;
    }

    private final void d() {
        e();
        setClipToOutline(true);
        setOutlineProvider(new b());
    }

    private final void e() {
        this.mAvatarSizeMap.put(40, 4);
        this.mAvatarSizeMap.put(100, 3);
        this.mAvatarSizeMap.put(140, 0);
        this.mAvatarSizeMap.put(640, 1);
        this.mAvatarSizeMap.put(1024, 2);
    }

    private final void f(String from) {
        if (TextUtils.isEmpty(this.tinyId) && TextUtils.isEmpty(this.mAvatarMeta)) {
            QLog.w(this.mTag, 1, "loadImage params error " + this.mGuildId + "-" + this.tinyId + "-" + from);
        } else {
            int i3 = this.mNeedSize;
            if (i3 == -1) {
                QLog.w(this.mTag, 1, "loadImage size error " + this.mGuildId + "-" + this.tinyId + "-" + i3 + "-" + from);
            }
        }
        if (!TextUtils.isEmpty(this.mAvatarMeta) && this.loadType == 1) {
            setImageDrawable(URLDrawable.getDrawable(this.mAvatarMeta, (URLDrawable.URLDrawableOptions) null));
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.mTag, 2, "loadImage from:", from, " ", this.mGuildId, "-", this.tinyId, "-", this.mAvatarMeta, "-", Integer.valueOf(this.mNeedSize), " code:", Integer.valueOf(hashCode()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GuildUserAvatarView this$0, int i3, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.setTag(i3, obj);
    }

    /* renamed from: c, reason: from getter */
    protected final int getMRoundRectRadius() {
        return this.mRoundRectRadius;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        this.mNeedSize = b(w3);
        f(MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED);
    }

    public final void setAvatarMeta(String guildId, String tinyId, String avatarMeta) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(avatarMeta, "avatarMeta");
        if (!TextUtils.equals(this.tinyId, tinyId)) {
            setTag(R.id.f165440w05, null);
        }
        this.mGuildId = guildId;
        this.tinyId = tinyId;
        this.mAvatarMeta = avatarMeta;
        if (this.mNeedSize != -1) {
            f("setAvatarMeta");
        }
    }

    public final void setAvatarSize(int needSize) {
        this.mNeedSize = needSize;
    }

    public final void setAvatarTinyId(String guildId, String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (!TextUtils.equals(this.tinyId, tinyId)) {
            setTag(R.id.f165440w05, null);
        }
        this.mGuildId = guildId;
        this.tinyId = tinyId;
        if (this.mNeedSize != -1) {
            f("setAvatarTinyId");
        }
    }

    public final void setLoadType(int loadType) {
        this.loadType = loadType;
    }

    public final void setLogTag(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.mTag = G + tag;
    }

    public final void setNeedListenChange(boolean needListenChange) {
        this.mNeedListenChange = needListenChange;
    }

    public final void setRoundRect(int radius) {
        int i3 = this.mRoundRectRadius;
        if (radius != i3) {
            if (radius >= 0 || i3 >= 0) {
                this.mRoundRectRadius = radius;
                invalidateOutline();
            }
        }
    }

    @Override // android.view.View
    public void setTag(final int key, final Object tag) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            super.setTag(key, tag);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: x74.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildUserAvatarView.g(GuildUserAvatarView.this, key, tag);
                }
            });
            QLog.e(this.mTag, 1, "setTag in subThread error");
        }
    }

    public GuildUserAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTag = "GuildUserAvatarView";
        this.mGuildId = "0";
        this.tinyId = "";
        this.mAvatarMeta = "";
        this.mNeedListenChange = true;
        this.mNeedSize = -1;
        this.mRoundRectRadius = -1;
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.loadType = 1;
        d();
    }

    public GuildUserAvatarView(Context context) {
        super(context);
        this.mTag = "GuildUserAvatarView";
        this.mGuildId = "0";
        this.tinyId = "";
        this.mAvatarMeta = "";
        this.mNeedListenChange = true;
        this.mNeedSize = -1;
        this.mRoundRectRadius = -1;
        this.mAvatarSizeMap = new LinkedHashMap<>();
        this.loadType = 1;
        d();
    }
}
