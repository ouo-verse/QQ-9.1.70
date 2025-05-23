package com.qzone.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019B%\b\u0016\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0014R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/widget/QZoneAlbumAvatarLoopView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lcooperation/qzone/UndealCount/QZoneCountInfo;", "", "initView", "", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "m0", "", "", "e", "Ljava/util/List;", "mAvatarLoopUinList", "Lcom/qzone/reborn/widget/QZoneAvatarLoopView;", "f", "Lcom/qzone/reborn/widget/QZoneAvatarLoopView;", "mLoopAvatar", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAlbumAvatarLoopView extends QZoneBaseWidgetView<QZoneCountInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<Long> mAvatarLoopUinList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneAvatarLoopView mLoopAvatar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumAvatarLoopView(Context context) {
        super(context);
        List<Long> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mAvatarLoopUinList = emptyList;
        View findViewById = findViewById(R.id.f19034l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatarLoopView)");
        this.mLoopAvatar = (QZoneAvatarLoopView) findViewById;
        initView();
    }

    private final void initView() {
        this.mLoopAvatar.setNeedAvatarClick(false);
        this.mLoopAvatar.setMaxAvatarCount(3);
        this.mLoopAvatar.setLoopDelayMs(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
        this.mLoopAvatar.setLoopAnimationDuration(500);
        this.mLoopAvatar.setTranslationX(0.0f);
        this.mLoopAvatar.setAlpha(1.0f);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f128533m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneCountInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
        List<Long> h16 = com.qzone.reborn.feedx.util.j.f55760a.h(objData);
        if (RFSafeListUtils.isEmpty(h16)) {
            return;
        }
        this.mAvatarLoopUinList = h16;
        this.mLoopAvatar.J();
        this.mLoopAvatar.K(h16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAlbumAvatarLoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        List<Long> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mAvatarLoopUinList = emptyList;
        View findViewById = findViewById(R.id.f19034l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatarLoopView)");
        this.mLoopAvatar = (QZoneAvatarLoopView) findViewById;
        initView();
    }

    public QZoneAlbumAvatarLoopView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<Long> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mAvatarLoopUinList = emptyList;
        View findViewById = findViewById(R.id.f19034l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatarLoopView)");
        this.mLoopAvatar = (QZoneAvatarLoopView) findViewById;
        initView();
    }
}
