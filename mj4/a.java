package mj4;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qqlive.widget.chat.event.FontSizeChangeEvent;
import com.tencent.mobileqq.qqlive.widget.chat.font.FontSize;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.font.QQLiveRangeButtonView;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010.\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lmj4/a;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$b;", "Landroid/view/View$OnClickListener;", "", "l0", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "fontSize", "", "k0", "", "j0", "position", "m0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "lastPosition", "newPosition", "onChange", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/util/DisplayMetrics;", "T", "Landroid/util/DisplayMetrics;", "systemMetrics", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "displayIv", "V", "backIv", "Landroid/widget/TextView;", "W", "Landroid/widget/TextView;", "titleTv", "X", "saveTv", "Y", "Landroid/view/View;", "displayContainerView", "Z", "dialogView", "a0", "Lcom/tencent/mobileqq/qqlive/widget/chat/font/FontSize;", "currentFontSize", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "b0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a extends BaseSlideUpDialog implements QQLiveRangeButtonView.b, View.OnClickListener {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final DisplayMetrics systemMetrics;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ImageView displayIv;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private ImageView backIv;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView titleTv;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TextView saveTv;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private View displayContainerView;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private View dialogView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FontSize currentFontSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lmj4/a$a;", "", "Landroid/content/Context;", "context", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mj4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            new a(context).show();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416871a;

        static {
            int[] iArr = new int[FontSize.values().length];
            try {
                iArr[FontSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FontSize.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FontSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f416871a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.systemMetrics = new DisplayMetrics();
    }

    private final int j0() {
        int i3 = b.f416871a[com.tencent.mobileqq.qqlive.widget.chat.font.a.f273775a.a().ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            if (i3 != 2 && i3 == 3) {
                i16 = 2;
            }
        } else {
            i16 = 0;
        }
        m0(i16);
        return i16;
    }

    private final float k0(FontSize fontSize) {
        return TypedValue.applyDimension(2, fontSize.getSp(), this.systemMetrics);
    }

    private final void l0() {
        QQLiveRangeButtonView qQLiveRangeButtonView = (QQLiveRangeButtonView) findViewById(R.id.vd7);
        ArrayList arrayList = new ArrayList();
        FontSize fontSize = FontSize.SMALL;
        arrayList.add(new QQLiveRangeButtonView.e(fontSize.getDesc(), k0(fontSize), null, 4, null));
        FontSize fontSize2 = FontSize.STANDARD;
        arrayList.add(new QQLiveRangeButtonView.e(fontSize2.getDesc(), k0(fontSize2), null, 4, null));
        FontSize fontSize3 = FontSize.LARGE;
        arrayList.add(new QQLiveRangeButtonView.e(fontSize3.getDesc(), k0(fontSize3), null, 4, null));
        qQLiveRangeButtonView.setTitleColor(ContextCompat.getColor(this.G, R.color.qvideo_skin_color_text_primary));
        qQLiveRangeButtonView.setTitleData(arrayList);
        qQLiveRangeButtonView.setOnChangerListener(this);
        qQLiveRangeButtonView.setThumbPosition(j0());
    }

    private final void m0(int position) {
        String str;
        if (position != 0) {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/8968/qqlive/qvideo_img_qqlive_textsize_default.png";
            if (position != 1) {
                if (position != 2) {
                    this.currentFontSize = FontSize.STANDARD;
                } else {
                    this.currentFontSize = FontSize.LARGE;
                    str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/8968/qqlive/qvideo_img_qqlive_textsize_large.png";
                }
            } else {
                this.currentFontSize = FontSize.STANDARD;
            }
        } else {
            this.currentFontSize = FontSize.SMALL;
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/8968/qqlive/qvideo_img_qqlive_textsize_small.png";
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setTargetView(this.displayIv).setPredecode(true));
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.font.QQLiveRangeButtonView.b
    public void onChange(int lastPosition, int newPosition) {
        m0(newPosition);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f165262vd4) {
            dismiss();
        } else if (num != null && num.intValue() == R.id.f165261vd3) {
            FontSize fontSize = this.currentFontSize;
            if (fontSize != null) {
                com.tencent.mobileqq.qqlive.widget.chat.font.a.f273775a.b(fontSize);
                SimpleEventBus.getInstance().dispatchEvent(new FontSizeChangeEvent(fontSize));
            }
            dismiss();
        } else {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.systemMetrics.setTo(GlobalDisplayMetricsManager.sOriginDisplayMetrics);
        setContentView(R.layout.h_k);
        ImageView imageView = (ImageView) findViewById(R.id.f165258vd0);
        imageView.setOnClickListener(this);
        imageView.setImageResource(R.drawable.qvideo_skin_icon_general_arrow_left_primary);
        this.backIv = imageView;
        TextView textView = (TextView) findViewById(R.id.vd5);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qvideo_skin_color_text_primary));
        this.titleTv = textView;
        TextView textView2 = (TextView) findViewById(R.id.f165261vd3);
        textView2.setOnClickListener(this);
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), R.color.qvideo_skin_color_text_primary));
        this.saveTv = textView2;
        View findViewById = findViewById(R.id.vd6);
        findViewById.setBackgroundColor(ContextCompat.getColor(findViewById.getContext(), R.color.qvideo_skin_color_bg_skeleton));
        this.displayContainerView = findViewById;
        View findViewById2 = findViewById(R.id.f165259vd1);
        findViewById2.setBackgroundResource(R.drawable.qvideo_skin_font_size_setting_view_bg);
        e0(this.dialogView);
        this.dialogView = findViewById2;
        findViewById(R.id.f165262vd4).setOnClickListener(this);
        this.displayIv = (ImageView) findViewById(R.id.f165260vd2);
        l0();
    }
}
