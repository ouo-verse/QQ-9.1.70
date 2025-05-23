package com.tencent.ntcompose.foundation.layout.base;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b>\u0010?R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/ntcompose/foundation/layout/base/e;", "Lcom/tencent/kuikly/core/layout/c;", "Lcom/tencent/ntcompose/foundation/layout/base/f;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/ntcompose/foundation/layout/base/f;", UserInfo.SEX_FEMALE, "()Lcom/tencent/ntcompose/foundation/layout/base/f;", "N", "(Lcom/tencent/ntcompose/foundation/layout/base/f;)V", "atMostWidth", "t", "E", "M", "atMostHeight", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "u", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "G", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment;", "O", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment;)V", "boxAlignment", "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "v", "Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "L", "()Lcom/tencent/ntcompose/foundation/layout/base/a$k;", "T", "(Lcom/tencent/ntcompose/foundation/layout/base/a$k;)V", "verticalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "w", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "H", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;", "P", "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Horizontal;)V", "horizontalAlignment", "Lcom/tencent/ntcompose/foundation/layout/base/a$d;", HippyTKDListViewAdapter.X, "Lcom/tencent/ntcompose/foundation/layout/base/a$d;", "I", "()Lcom/tencent/ntcompose/foundation/layout/base/a$d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lcom/tencent/ntcompose/foundation/layout/base/a$d;)V", "horizontalArrangement", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "y", "Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", "K", "()Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/ntcompose/foundation/layout/base/Alignment$Vertical;)V", ImageNode.PROP_VERTICAL_ALIGNMENT, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ljava/lang/Object;", "J", "()Ljava/lang/Object;", BdhLogUtil.LogTag.Tag_Req, "(Ljava/lang/Object;)V", "layoutDataForParent", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends com.tencent.kuikly.core.layout.c {

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private f atMostWidth;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private f atMostHeight;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private Alignment boxAlignment;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private a.k verticalArrangement;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private Alignment.Horizontal horizontalAlignment;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private a.d horizontalArrangement;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private Alignment.Vertical verticalAlignment;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private Object layoutDataForParent;

    /* renamed from: E, reason: from getter */
    public final f getAtMostHeight() {
        return this.atMostHeight;
    }

    /* renamed from: F, reason: from getter */
    public final f getAtMostWidth() {
        return this.atMostWidth;
    }

    /* renamed from: G, reason: from getter */
    public final Alignment getBoxAlignment() {
        return this.boxAlignment;
    }

    /* renamed from: H, reason: from getter */
    public final Alignment.Horizontal getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* renamed from: I, reason: from getter */
    public final a.d getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    /* renamed from: J, reason: from getter */
    public final Object getLayoutDataForParent() {
        return this.layoutDataForParent;
    }

    /* renamed from: K, reason: from getter */
    public final Alignment.Vertical getVerticalAlignment() {
        return this.verticalAlignment;
    }

    /* renamed from: L, reason: from getter */
    public final a.k getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public final void M(f fVar) {
        this.atMostHeight = fVar;
    }

    public final void N(f fVar) {
        this.atMostWidth = fVar;
    }

    public final void O(Alignment alignment) {
        this.boxAlignment = alignment;
    }

    public final void P(Alignment.Horizontal horizontal) {
        this.horizontalAlignment = horizontal;
    }

    public final void Q(a.d dVar) {
        this.horizontalArrangement = dVar;
    }

    public final void R(Object obj) {
        this.layoutDataForParent = obj;
    }

    public final void S(Alignment.Vertical vertical) {
        this.verticalAlignment = vertical;
    }

    public final void T(a.k kVar) {
        this.verticalArrangement = kVar;
    }
}
