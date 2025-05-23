package kl4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.notice.TimiNoticeEditFragment;
import com.tencent.timi.game.widget.MediumBoldTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lkl4/m;", "Lcom/tencent/timi/game/ui/widget/a;", "Landroid/view/View$OnClickListener;", "", "initView", "Landroid/view/View;", "U", ExifInterface.LATITUDE_SOUTH, "v", NodeProps.ON_CLICK, "", "K", "J", "roomId", "L", "anchorId", "", "M", "Ljava/lang/String;", "noticeContent", "N", "Landroid/view/View;", "bgView", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "P", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "leftButton", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "rightButton", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/RelativeLayout;", "contentView", "Landroid/content/Context;", "dialogContext", "<init>", "(Landroid/content/Context;JJLjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class m extends com.tencent.timi.game.ui.widget.a implements View.OnClickListener {

    /* renamed from: K, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: L, reason: from kotlin metadata */
    private final long anchorId;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final String noticeContent;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private View bgView;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private MediumBoldTextView leftButton;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private MediumBoldTextView rightButton;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private RelativeLayout contentView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull Context dialogContext, long j3, long j16, @Nullable String str) {
        super(dialogContext);
        Intrinsics.checkNotNullParameter(dialogContext, "dialogContext");
        this.roomId = j3;
        this.anchorId = j16;
        this.noticeContent = str;
        setContentView(View.inflate(dialogContext, R.layout.f169123hv3, null));
        View findViewById = findViewById(R.id.t67);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bgView)");
        this.bgView = findViewById;
        View findViewById2 = findViewById(R.id.ygn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.leftButton)");
        this.leftButton = (MediumBoldTextView) findViewById2;
        View findViewById3 = findViewById(R.id.f74373w3);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.rightButton)");
        this.rightButton = (MediumBoldTextView) findViewById3;
        View findViewById4 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.contentView)");
        this.contentView = (RelativeLayout) findViewById4;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView() {
        RelativeLayout relativeLayout = this.contentView;
        if (relativeLayout != null) {
            fh4.g.f(relativeLayout, fh4.b.b(6), Color.parseColor("#20202C"));
        }
        View view = this.bgView;
        if (view != null) {
            view.setOnClickListener(this);
        }
        this.leftButton.setOnClickListener(this);
        this.rightButton.setOnClickListener(this);
        RelativeLayout relativeLayout2 = this.contentView;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: kl4.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.Y(view2);
                }
            });
        }
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    /* renamed from: S, reason: from getter */
    public View getBgView() {
        return this.bgView;
    }

    @Override // com.tencent.timi.game.ui.widget.a
    @NotNull
    public View U() {
        return this.contentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!com.tencent.timi.game.utils.o.a()) {
            int id5 = v3.getId();
            if (id5 == R.id.ygn) {
                dismiss();
            } else if (id5 == R.id.f74373w3) {
                Activity d16 = com.tencent.timi.game.utils.b.d(v3);
                if (d16 != null) {
                    TimiNoticeEditFragment.xh(d16, this.noticeContent, this.roomId, this.anchorId);
                }
                dismiss();
            } else if (id5 == R.id.t67) {
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
