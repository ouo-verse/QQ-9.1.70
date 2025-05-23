package com.tencent.biz.pubaccount.weishi.profile.header;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001#B\u0011\b\u0016\u0012\u0006\u0010U\u001a\u00020T\u00a2\u0006\u0004\bV\u0010WB\u001b\b\u0016\u0012\u0006\u0010U\u001a\u00020T\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u00a2\u0006\u0004\bV\u0010ZJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001a\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020&H\u0016J\u0012\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-H\u0016R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u00101R\u0016\u00104\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u00106R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u00106R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00106R\u0016\u0010<\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00106R\u0016\u0010>\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00106R\u0016\u0010@\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00106R\u0016\u0010B\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u00106R\u0016\u0010D\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u00106R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\b3\u0010R\u00a8\u0006\\"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/WSProfileHeaderView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/pubaccount/weishi/profile/header/g;", "", "g", tl.h.F, "Landroid/graphics/drawable/GradientDrawable;", "d", "j", "Lcom/tencent/biz/pubaccount/weishi/profile/header/f;", "presenter", "setPresenter", "f", "", PhotoCategorySummaryInfo.AVATAR_URL, "b", "nick", "setNick", "", "rightSmallBtnRes", "setRightSmallBtnImage", "text", "", "textSize", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "setRightBigBtnImage", "Lcom/tencent/biz/pubaccount/weishi/profile/header/i;", "sexInfo", "setSex", "location", "locationDrawable", "setLocation", "coverUrl", "a", "signature", "setSignature", "", "followCntText", "setFollowCnt", "fansCntText", "setFansCnt", "receivePraiseCnt", "setReceivePraiseCnt", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mAvatarView", "e", "mRightSmallBtnView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mRightBigBtnView", "mTvNick", "i", "mTvSex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTvLocation", BdhLogUtil.LogTag.Tag_Conn, "mTvSignature", "D", "mTvFollowCnt", "E", "mTvFansCnt", UserInfo.SEX_FEMALE, "mTvReceivePraiseCnt", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "G", "Lcom/tencent/mobileqq/kandian/base/view/widget/KandianUrlImageView;", "mIvCover", "H", "Landroid/view/View;", "mTagContainerView", "I", "Lcom/tencent/biz/pubaccount/weishi/profile/header/f;", "mPresenter", "Landroid/graphics/drawable/ColorDrawable;", "J", "Lkotlin/Lazy;", "()Landroid/graphics/drawable/ColorDrawable;", "mCoverPlaceholderDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "K", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSProfileHeaderView extends FrameLayout implements View.OnClickListener, g {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTvSignature;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mTvFollowCnt;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mTvFansCnt;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mTvReceivePraiseCnt;

    /* renamed from: G, reason: from kotlin metadata */
    private KandianUrlImageView mIvCover;

    /* renamed from: H, reason: from kotlin metadata */
    private View mTagContainerView;

    /* renamed from: I, reason: from kotlin metadata */
    private f mPresenter;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy mCoverPlaceholderDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mAvatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mRightSmallBtnView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mRightBigBtnView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTvNick;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mTvSex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mTvLocation;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WSProfileHeaderView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ColorDrawable e() {
        return (ColorDrawable) this.mCoverPlaceholderDrawable.getValue();
    }

    private final void g() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.d1c, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (i3 >= childCount) {
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            viewGroup.removeView(childAt);
            addView(childAt);
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(WSProfileHeaderView this$0, String coverUrl) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coverUrl, "$coverUrl");
        KandianUrlImageView kandianUrlImageView = this$0.mIvCover;
        KandianUrlImageView kandianUrlImageView2 = null;
        if (kandianUrlImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
            kandianUrlImageView = null;
        }
        ViewGroup.LayoutParams layoutParams = kandianUrlImageView.getLayoutParams();
        layoutParams.width = -1;
        KandianUrlImageView kandianUrlImageView3 = this$0.mIvCover;
        if (kandianUrlImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
            kandianUrlImageView3 = null;
        }
        kandianUrlImageView3.setLayoutParams(layoutParams);
        isBlank = StringsKt__StringsJVMKt.isBlank(coverUrl);
        if (isBlank) {
            KandianUrlImageView kandianUrlImageView4 = this$0.mIvCover;
            if (kandianUrlImageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
            } else {
                kandianUrlImageView2 = kandianUrlImageView4;
            }
            kandianUrlImageView2.setImageDrawable(this$0.e());
            return;
        }
        ColorDrawable e16 = this$0.e();
        KandianUrlImageView kandianUrlImageView5 = this$0.mIvCover;
        if (kandianUrlImageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
        } else {
            kandianUrlImageView2 = kandianUrlImageView5;
        }
        WSProfileHeaderUtils.a(coverUrl, e16, kandianUrlImageView2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j() {
        boolean z16;
        View view;
        TextView textView = this.mTvSex;
        View view2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSex");
            textView = null;
        }
        if (textView.getVisibility() != 0) {
            TextView textView2 = this.mTvLocation;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLocation");
                textView2 = null;
            }
            if (textView2.getVisibility() != 0) {
                z16 = false;
                view = this.mTagContainerView;
                if (view != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTagContainerView");
                } else {
                    view2 = view;
                }
                view2.setVisibility(z16 ? 0 : 8);
            }
        }
        z16 = true;
        view = this.mTagContainerView;
        if (view != null) {
        }
        view2.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void a(final String coverUrl) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        KandianUrlImageView kandianUrlImageView = this.mIvCover;
        if (kandianUrlImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCover");
            kandianUrlImageView = null;
        }
        kandianUrlImageView.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.h
            @Override // java.lang.Runnable
            public final void run() {
                WSProfileHeaderView.i(WSProfileHeaderView.this, coverUrl);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void b(String avatarUrl) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        WSPicLoader g16 = WSPicLoader.g();
        Context context = getContext();
        ImageView imageView = this.mAvatarView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            imageView = null;
        }
        g16.j(context, imageView, avatarUrl);
    }

    public final f f() {
        f fVar = this.mPresenter;
        if (fVar != null) {
            return fVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        ImageView imageView = this.mRightSmallBtnView;
        f fVar = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightSmallBtnView");
            imageView = null;
        }
        if (Intrinsics.areEqual(v3, imageView)) {
            f fVar2 = this.mPresenter;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            } else {
                fVar = fVar2;
            }
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            fVar.f(context);
            return;
        }
        TextView textView = this.mRightBigBtnView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightBigBtnView");
            textView = null;
        }
        if (Intrinsics.areEqual(v3, textView)) {
            f fVar3 = this.mPresenter;
            if (fVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            } else {
                fVar = fVar3;
            }
            Context context2 = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "v.context");
            fVar.g(context2);
            return;
        }
        TextView textView2 = this.mTvFollowCnt;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
            textView2 = null;
        }
        if (Intrinsics.areEqual(v3, textView2)) {
            f fVar4 = this.mPresenter;
            if (fVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            } else {
                fVar = fVar4;
            }
            Context context3 = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "v.context");
            fVar.a(context3);
            return;
        }
        TextView textView3 = this.mTvFansCnt;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
            textView3 = null;
        }
        if (Intrinsics.areEqual(v3, textView3)) {
            f fVar5 = this.mPresenter;
            if (fVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            } else {
                fVar = fVar5;
            }
            Context context4 = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "v.context");
            fVar.d(context4);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setFansCnt(CharSequence fansCntText) {
        Intrinsics.checkNotNullParameter(fansCntText, "fansCntText");
        TextView textView = this.mTvFansCnt;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
            textView = null;
        }
        textView.setText(fansCntText);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setFollowCnt(CharSequence followCntText) {
        Intrinsics.checkNotNullParameter(followCntText, "followCntText");
        TextView textView = this.mTvFollowCnt;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
            textView = null;
        }
        textView.setText(followCntText);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setLocation(String location, Drawable locationDrawable) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(location, "location");
        TextView textView = this.mTvLocation;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLocation");
            textView = null;
        }
        textView.setText(location);
        isBlank = StringsKt__StringsJVMKt.isBlank(location);
        textView.setVisibility(isBlank ? 8 : 0);
        textView.setCompoundDrawables(locationDrawable, null, null, null);
        j();
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setNick(String nick) {
        Intrinsics.checkNotNullParameter(nick, "nick");
        TextView textView = this.mTvNick;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvNick");
            textView = null;
        }
        textView.setText(nick);
    }

    public final void setPresenter(f presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.mPresenter = presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            presenter = null;
        }
        presenter.e(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setReceivePraiseCnt(CharSequence receivePraiseCnt) {
        Intrinsics.checkNotNullParameter(receivePraiseCnt, "receivePraiseCnt");
        TextView textView = this.mTvReceivePraiseCnt;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvReceivePraiseCnt");
            textView = null;
        }
        textView.setText(receivePraiseCnt);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setRightBigBtnImage(String text, float textSize, Drawable bgDrawable) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(bgDrawable, "bgDrawable");
        TextView textView = this.mRightBigBtnView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightBigBtnView");
            textView = null;
        }
        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setBackgroundDrawable(bgDrawable);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setRightSmallBtnImage(int rightSmallBtnRes) {
        ImageView imageView = this.mRightSmallBtnView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightSmallBtnView");
            imageView = null;
        }
        imageView.setImageResource(rightSmallBtnRes);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setSex(i sexInfo) {
        Intrinsics.checkNotNullParameter(sexInfo, "sexInfo");
        TextView textView = null;
        if (!sexInfo.getIsVisible()) {
            TextView textView2 = this.mTvSex;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvSex");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.mTvSex;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSex");
            textView3 = null;
        }
        textView3.setVisibility(0);
        textView3.setText(sexInfo.getText());
        textView3.setCompoundDrawables(sexInfo.getIconDrawable(), null, null, null);
        textView3.setTextColor(sexInfo.getTextColor());
        textView3.setBackgroundDrawable(sexInfo.getBgDrawable());
        j();
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.g
    public void setSignature(String signature) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        TextView textView = this.mTvSignature;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSignature");
            textView = null;
        }
        textView.setText(signature);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSProfileHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ColorDrawable>() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.WSProfileHeaderView$mCoverPlaceholderDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorDrawable invoke() {
                return new ColorDrawable(ag.a(R.color.f7594o));
            }
        });
        this.mCoverPlaceholderDrawable = lazy;
        g();
        h();
    }

    private final GradientDrawable d() {
        GradientDrawable a16 = ba.a(ag.a(R.color.f7815_), ba.f81734i);
        Intrinsics.checkNotNullExpressionValue(a16, "createRoundRectangleDraw\u2026.PIX_10DP.toFloat()\n    )");
        return a16;
    }

    private final void h() {
        View findViewById = findViewById(R.id.p4l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_profile_header_avatar)");
        this.mAvatarView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.p4n);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_pro\u2026e_header_right_small_btn)");
        this.mRightSmallBtnView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f163275p83);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_profile_header_right_big_btn)");
        this.mRightBigBtnView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f163273p81);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_profile_header_nick)");
        this.mTvNick = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f163276p84);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_profile_header_sex)");
        this.mTvSex = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f163272p80);
        TextView textView = (TextView) findViewById6;
        textView.setBackgroundDrawable(d());
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById<TextView>(R\u2026ionDefaultBg())\n        }");
        this.mTvLocation = textView;
        View findViewById7 = findViewById(R.id.p85);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_profile_header_signature)");
        this.mTvSignature = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.p7z);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_profile_header_follow_cnt)");
        this.mTvFollowCnt = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.p7y);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_profile_header_fans_cnt)");
        this.mTvFansCnt = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.f163274p82);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.tv_pro\u2026eader_receive_praise_cnt)");
        this.mTvReceivePraiseCnt = (TextView) findViewById10;
        View findViewById11 = findViewById(R.id.p4m);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.iv_profile_header_cover)");
        this.mIvCover = (KandianUrlImageView) findViewById11;
        View findViewById12 = findViewById(R.id.p4y);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.ll_profile_header_tag_container)");
        this.mTagContainerView = findViewById12;
        ImageView imageView = this.mRightSmallBtnView;
        TextView textView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightSmallBtnView");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        TextView textView3 = this.mRightBigBtnView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRightBigBtnView");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        TextView textView4 = this.mTvFollowCnt;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFollowCnt");
            textView4 = null;
        }
        textView4.setOnClickListener(this);
        TextView textView5 = this.mTvFansCnt;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvFansCnt");
            textView5 = null;
        }
        textView5.setOnClickListener(this);
        TextView textView6 = this.mTvReceivePraiseCnt;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvReceivePraiseCnt");
        } else {
            textView2 = textView6;
        }
        textView2.setOnClickListener(this);
    }
}
