package com.tencent.sqshow.zootopia.usercenter.friend.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001b\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView;", "Landroid/widget/RelativeLayout;", "", "f", "", "uin", "", "relation", "setRelation", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView$b;", "changeListener", "setRelationUpdateListener", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "loadingView", "I", h.F, "J", "i", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView$b;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanUserCenterFollowView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int relation;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long uin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b changeListener;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView$b;", "", "", "uin", "", "relation", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(long uin, int relation);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterFollowView$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements e<su4.h> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ImageView imageView = ZPlanUserCenterFollowView.this.loadingView;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            ImageView imageView2 = ZPlanUserCenterFollowView.this.loadingView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView = ZPlanUserCenterFollowView.this.textView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            ZPlanUserCenterFollowView zPlanUserCenterFollowView = ZPlanUserCenterFollowView.this;
            su4.e eVar = result.f434790a;
            zPlanUserCenterFollowView.setRelation(eVar.f434782a, eVar.f434783b);
            b bVar = ZPlanUserCenterFollowView.this.changeListener;
            if (bVar != null) {
                su4.e eVar2 = result.f434790a;
                bVar.a(eVar2.f434782a, eVar2.f434783b);
            }
            QLog.e("ZPlanUserCenterFollowView", 1, "updateRelation :: follow state after , relation == " + result.f434790a.f434783b);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ImageView imageView = ZPlanUserCenterFollowView.this.loadingView;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            ImageView imageView2 = ZPlanUserCenterFollowView.this.loadingView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView = ZPlanUserCenterFollowView.this.textView;
            if (textView != null) {
                textView.setVisibility(0);
            }
            QLog.e("ZPlanUserCenterFollowView", 1, "updateRelation :: error == " + error + " , message == " + message);
            if (error == 9200010) {
                QQToastUtil.showQQToast(0, message);
            } else {
                QQToastUtil.showQQToast(0, R.string.xjj);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUserCenterFollowView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.f167470dh4, this);
        this.textView = (TextView) findViewById(R.id.f163577qw0);
        this.loadingView = (ImageView) findViewById(R.id.qvz);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.friend.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanUserCenterFollowView.b(ZPlanUserCenterFollowView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanUserCenterFollowView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    private final void f() {
        if (this.uin <= 0) {
            QLog.e("ZPlanUserCenterFollowView", 1, "uin is empty");
            return;
        }
        ImageView imageView = this.loadingView;
        if (imageView != null && imageView.getVisibility() == 0) {
            QLog.e("ZPlanUserCenterFollowView", 1, "loading now");
            return;
        }
        ImageView imageView2 = this.loadingView;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        TextView textView = this.textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setRepeatCount(-1);
        ImageView imageView3 = this.loadingView;
        if (imageView3 != null) {
            imageView3.startAnimation(rotateAnimation);
        }
        QLog.i("ZPlanUserCenterFollowView", 1, "updateRelation :: follow state before , relation == " + this.relation);
        lc4.a.f414373a.i(this.uin, this.relation, new c());
    }

    public final void setRelationUpdateListener(b changeListener) {
        Intrinsics.checkNotNullParameter(changeListener, "changeListener");
        this.changeListener = changeListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUserCenterFollowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.f167470dh4, this);
        this.textView = (TextView) findViewById(R.id.f163577qw0);
        this.loadingView = (ImageView) findViewById(R.id.qvz);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.usercenter.friend.ui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanUserCenterFollowView.b(ZPlanUserCenterFollowView.this, view);
            }
        });
    }

    public final void setRelation(long uin, int relation) {
        TextView textView;
        if (relation != 0) {
            if (relation == 1) {
                TextView textView2 = this.textView;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.textView;
                if (textView3 != null) {
                    textView3.setText(R.string.xwp);
                }
                TextView textView4 = this.textView;
                if (textView4 != null) {
                    textView4.setTextColor(-16777216);
                }
                setBackgroundResource(R.drawable.i2p);
                ImageView imageView = this.loadingView;
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.f159878if3);
                }
            } else if (relation != 2) {
                if (relation == 3) {
                    TextView textView5 = this.textView;
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                    TextView textView6 = this.textView;
                    if (textView6 != null) {
                        textView6.setText(R.string.xwq);
                    }
                    TextView textView7 = this.textView;
                    if (textView7 != null) {
                        textView7.setTextColor(-16777216);
                    }
                    setBackgroundResource(R.drawable.i2p);
                    ImageView imageView2 = this.loadingView;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.f159878if3);
                    }
                } else if (relation == 4 && (textView = this.textView) != null) {
                    textView.setVisibility(8);
                }
            }
            this.relation = relation;
            this.uin = uin;
        }
        TextView textView8 = this.textView;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        TextView textView9 = this.textView;
        if (textView9 != null) {
            textView9.setText(R.string.xwo);
        }
        TextView textView10 = this.textView;
        if (textView10 != null) {
            textView10.setTextColor(-1);
        }
        setBackgroundResource(R.drawable.i2q);
        ImageView imageView3 = this.loadingView;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.f159879if4);
        }
        this.relation = relation;
        this.uin = uin;
    }
}
