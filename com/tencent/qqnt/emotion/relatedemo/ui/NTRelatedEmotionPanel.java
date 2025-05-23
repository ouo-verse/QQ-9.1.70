package com.tencent.qqnt.emotion.relatedemo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import com.tencent.qqnt.emotion.relatedemo.RelatedEmoSearchEmoticonInfo;
import com.tencent.qqnt.emotion.relatedemo.RelatedEmoSlideBottomPanel;
import com.tencent.qqnt.emotion.relatedemo.k;
import com.tencent.qqnt.emotion.relatedemo.m;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 g2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001#B'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020\u001e\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J&\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u0012\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u000eH\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0016J\u0006\u0010+\u001a\u00020\u0005R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00106\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010CR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006h"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/ui/NTRelatedEmotionPanel;", "Landroid/widget/LinearLayout;", "Lcom/tencent/qqnt/emotion/relatedemo/m;", "Landroid/view/View$OnClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "", "l", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "mApp", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "p", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/RelativeLayout;", "k", "Lcom/tencent/image/URLImageView;", "emoticonImg", "j", "app", "Lcom/tencent/qqnt/emotion/relatedemo/b;", "callback", "Lcom/tencent/qqnt/emotion/relatedemo/a;", "expandHelper", "o", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "panelHeight", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult;", "result", "a", "errorCode", "onError", "v", NodeProps.ON_CLICK, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "r", "", "d", "Z", "mReportedNoMore", "e", "Landroid/view/View;", "getMFooterView", "()Landroid/view/View;", "setMFooterView", "(Landroid/view/View;)V", "mFooterView", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mMsgItem", "", h.F, "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "setMCurFriendUin", "(Ljava/lang/String;)V", "mCurFriendUin", "i", "I", "mCurType", "mLoadingStatus", "Landroid/app/Dialog;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Dialog;", "mSearchPanelDialog", "D", "Lcom/tencent/qqnt/emotion/relatedemo/a;", "mEmotionExpandHelper", "Lcom/tencent/qqnt/emotion/relatedemo/k;", "E", "Lcom/tencent/qqnt/emotion/relatedemo/k;", "mEmotionSearchAdapter", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/qqnt/emotion/relatedemo/logic/b;", "G", "Lcom/tencent/qqnt/emotion/relatedemo/logic/b;", "mNTRelatedEmoticonManager", "H", "Lcom/tencent/qqnt/emotion/relatedemo/b;", "mCallBack", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "J", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTRelatedEmotionPanel extends LinearLayout implements m, View.OnClickListener, DialogInterface.OnDismissListener {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Dialog mSearchPanelDialog;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.emotion.relatedemo.a mEmotionExpandHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private k mEmotionSearchAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mRecyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.emotion.relatedemo.logic.b mNTRelatedEmoticonManager;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.qqnt.emotion.relatedemo.b mCallBack;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private BaseQQAppInterface mApp;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mReportedNoMore;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mFooterView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem mMsgItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurFriendUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCurType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mLoadingStatus;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/ui/NTRelatedEmotionPanel$a;", "", "", "ITEM_TYPE_FIRST_LOAD_ERROR", "I", "ITEM_TYPE_INIT", "ITEM_TYPE_LOAD_EMPTY", "ITEM_TYPE_NO_LOAD_MORE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.ui.NTRelatedEmotionPanel$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/emotion/relatedemo/ui/NTRelatedEmotionPanel$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f356414e;

        b(BaseQQAppInterface baseQQAppInterface) {
            this.f356414e = baseQQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTRelatedEmotionPanel.this, (Object) baseQQAppInterface);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                AbstractGifImage.resumeAll();
            } else {
                AbstractGifImage.pauseAll();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            k kVar;
            List<EmotionPanelData> data;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (!recyclerView.canScrollVertically(1) && NTRelatedEmotionPanel.this.mLoadingStatus == 1 && !NTRelatedEmotionPanel.this.mReportedNoMore && (kVar = NTRelatedEmotionPanel.this.mEmotionSearchAdapter) != null && (data = kVar.getData()) != null) {
                NTRelatedEmotionPanel nTRelatedEmotionPanel = NTRelatedEmotionPanel.this;
                BaseQQAppInterface baseQQAppInterface = this.f356414e;
                nTRelatedEmotionPanel.mReportedNoMore = true;
                com.tencent.mobileqq.temp.report.a.a(baseQQAppInterface, "dc00898", "", nTRelatedEmotionPanel.n(), "0X800B156", "0X800B156", 0, 0, String.valueOf(data.size()), "", "", "");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/emotion/relatedemo/ui/NTRelatedEmotionPanel$c", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSlideBottomPanel$a;", "", Element.ELEMENT_NAME_DISTANCE, "", "b", "", "type", "a", "d", "c", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements RelatedEmoSlideBottomPanel.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTRelatedEmotionPanel.this);
            }
        }

        @Override // com.tencent.qqnt.emotion.relatedemo.RelatedEmoSlideBottomPanel.a
        public void a(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, type);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NTRelatedEmotionPanel", 2, "dismiss type: " + type);
            }
            if (type > -1) {
                com.tencent.mobileqq.temp.report.a.a(NTRelatedEmotionPanel.this.mApp, "dc00898", "", NTRelatedEmotionPanel.this.n(), "0X800B11A", "0X800B11A", type, 0, "", "", "", "");
            }
            NTRelatedEmotionPanel.this.l();
            if (type == 2) {
                AbstractGifImage.resumeAll();
            }
        }

        @Override // com.tencent.qqnt.emotion.relatedemo.RelatedEmoSlideBottomPanel.a
        public void b(float distance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                com.tencent.qqnt.emotion.relatedemo.a aVar = NTRelatedEmotionPanel.this.mEmotionExpandHelper;
                if (aVar != null) {
                    aVar.b(distance);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(distance));
        }

        @Override // com.tencent.qqnt.emotion.relatedemo.RelatedEmoSlideBottomPanel.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                AbstractGifImage.resumeAll();
            }
        }

        @Override // com.tencent.qqnt.emotion.relatedemo.RelatedEmoSlideBottomPanel.a
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                AbstractGifImage.pauseAll();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31301);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NTRelatedEmotionPanel(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
    }

    private final LinearLayout j(URLImageView emoticonImg) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(80.0f), ViewUtils.dip2px(80.0f));
        layoutParams.topMargin = ViewUtils.dip2px(6.0f);
        linearLayout.addView(emoticonImg, layoutParams);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        return linearLayout;
    }

    private final RelativeLayout k() {
        String str;
        String str2;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setId(R.id.jo7);
        textView.setTextSize(12.0f);
        if (isNowThemeIsNight) {
            str = "#8D8D93";
        } else {
            str = "#878B99";
        }
        textView.setTextColor(Color.parseColor(str));
        textView.setText(getContext().getResources().getString(R.string.f220766_0));
        textView.setGravity(17);
        textView.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        View view = new View(getContext());
        View view2 = new View(getContext());
        if (isNowThemeIsNight) {
            str2 = "#3D3D41";
        } else {
            str2 = "#EBEDF5";
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.jo7);
        layoutParams2.leftMargin = ViewUtils.dip2px(14.0f);
        layoutParams2.rightMargin = ViewUtils.dip2px(12.0f);
        view.setBackgroundColor(Color.parseColor(str2));
        view.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.addRule(1, R.id.jo7);
        layoutParams3.leftMargin = ViewUtils.dip2px(12.0f);
        layoutParams3.rightMargin = ViewUtils.dip2px(14.0f);
        view2.setBackgroundColor(Color.parseColor(str2));
        view2.setLayoutParams(layoutParams3);
        relativeLayout.addView(textView);
        relativeLayout.addView(view);
        relativeLayout.addView(view2);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        Dialog dialog;
        Dialog dialog2 = this.mSearchPanelDialog;
        boolean z16 = false;
        if (dialog2 != null && dialog2.isShowing()) {
            z16 = true;
        }
        if (z16 && (dialog = this.mSearchPanelDialog) != null) {
            dialog.dismiss();
        }
    }

    private final View m() {
        if (this.mFooterView == null) {
            View inflate = View.inflate(getContext(), R.layout.fqd, null);
            inflate.setBackgroundColor(0);
            inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(74.0f)));
            this.mFooterView = inflate;
        }
        q();
        return this.mFooterView;
    }

    private final void p(BaseQQAppInterface mApp, AIOMsgItem msgItem, URLDrawable urlDrawable) {
        URLImageView uRLImageView = new URLImageView(getContext());
        uRLImageView.setImageDrawable(urlDrawable);
        LinearLayout j3 = j(uRLImageView);
        RelativeLayout k3 = k();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = ViewUtils.dip2px(16.0f);
        layoutParams.topMargin = ViewUtils.dip2px(20.0f);
        j3.addView(k3, layoutParams);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.qqnt.emotion.relatedemo.b bVar = this.mCallBack;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallBack");
            bVar = null;
        }
        k kVar = new k(mApp, context, bVar);
        kVar.q0(this.mCurFriendUin, this.mCurType);
        kVar.p0(j3, m(), new ArrayList());
        this.mEmotionSearchAdapter = kVar;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.i4m);
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            recyclerView.setVerticalScrollBarEnabled(false);
            recyclerView.setAdapter(this.mEmotionSearchAdapter);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(new b(mApp));
        }
        com.tencent.qqnt.emotion.relatedemo.logic.b bVar2 = new com.tencent.qqnt.emotion.relatedemo.logic.b(mApp, this);
        bVar2.c(msgItem, this.mCurType);
        this.mNTRelatedEmoticonManager = bVar2;
    }

    private final void q() {
        if (this.mFooterView == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTRelatedEmotionPanel", 2, "notifyFooterViewChange.");
        }
        View view = this.mFooterView;
        Intrinsics.checkNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.d98);
        textView.setTextSize(14.0f);
        View view2 = this.mFooterView;
        Intrinsics.checkNotNull(view2);
        View findViewById = view2.findViewById(R.id.d97);
        View view3 = this.mFooterView;
        Intrinsics.checkNotNull(view3);
        TextView textView2 = (TextView) view3.findViewById(R.id.efo);
        textView2.setTextSize(14.0f);
        textView.setOnClickListener(this);
        View view4 = this.mFooterView;
        Intrinsics.checkNotNull(view4);
        ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
        int dip2px = ViewUtils.dip2px(74.0f);
        if (layoutParams.height != dip2px) {
            layoutParams.height = dip2px;
            View view5 = this.mFooterView;
            Intrinsics.checkNotNull(view5);
            view5.setLayoutParams(layoutParams);
        }
        int i3 = this.mLoadingStatus;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        textView.setVisibility(8);
                        findViewById.setVisibility(8);
                        layoutParams.height = -2;
                        View view6 = this.mFooterView;
                        Intrinsics.checkNotNull(view6);
                        view6.setLayoutParams(layoutParams);
                        return;
                    }
                    textView.setVisibility(0);
                    textView.setText(R.string.f220776_1);
                    textView.setClickable(false);
                    findViewById.setVisibility(4);
                    return;
                }
                textView.setVisibility(0);
                textView.setText(R.string.yq7);
                findViewById.setVisibility(4);
                com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B11B", "0X800B11B", 0, 0, "", "", "", "");
                return;
            }
            textView.setVisibility(0);
            textView.setText(R.string.f220786_2);
            textView.setClickable(false);
            findViewById.setVisibility(4);
            return;
        }
        findViewById.setVisibility(0);
        textView2.setText(R.string.f170217yq2);
        textView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(RelatedEmoSlideBottomPanel slideBottomPanel, DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(slideBottomPanel, "$slideBottomPanel");
        if (i3 == 4) {
            slideBottomPanel.l(4);
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.m
    public void a(@Nullable NTRelatedEmotionSearchResult result) {
        List<EmotionPanelData> list;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) result);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTRelatedEmotionPanel", 2, "onResult.");
        }
        if (this.mRecyclerView != null && this.mEmotionSearchAdapter != null && result != null) {
            List<NTRelatedEmotionSearchResult.SearchResultItem> b16 = result.b();
            k kVar = this.mEmotionSearchAdapter;
            if (kVar != null) {
                list = kVar.getData();
            } else {
                list = null;
            }
            List<EmotionPanelData> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                List<NTRelatedEmotionSearchResult.SearchResultItem> list3 = b16;
                if (list3 != null && !list3.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    this.mLoadingStatus = 3;
                    q();
                }
            }
            this.mLoadingStatus = 1;
            ArrayList arrayList = new ArrayList();
            if (b16 != null) {
                int size = b16.size();
                for (int i3 = 0; i3 < size; i3++) {
                    RelatedEmoSearchEmoticonInfo relatedEmoSearchEmoticonInfo = new RelatedEmoSearchEmoticonInfo(b16.get(i3), result.a());
                    relatedEmoSearchEmoticonInfo.e(this.mCurFriendUin, this.mCurType, i3);
                    arrayList.add(relatedEmoSearchEmoticonInfo);
                }
                k kVar2 = this.mEmotionSearchAdapter;
                if (kVar2 != null) {
                    kVar2.setData(arrayList);
                }
            }
            q();
        }
    }

    @NotNull
    protected final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCurFriendUin;
    }

    public final void o(@NotNull BaseQQAppInterface app, @NotNull com.tencent.qqnt.emotion.relatedemo.b callback, @NotNull com.tencent.qqnt.emotion.relatedemo.a expandHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, app, callback, expandHelper);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(expandHelper, "expandHelper");
        if (QLog.isColorLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 2, "init: app:" + app + ", mEmotionExpandHelper:" + expandHelper + ", mCallBack:" + callback);
        }
        this.mApp = app;
        this.mEmotionExpandHelper = expandHelper;
        this.mCallBack = callback;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        com.tencent.qqnt.emotion.relatedemo.logic.b bVar;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.d98) {
                this.mLoadingStatus = 0;
                q();
                AIOMsgItem aIOMsgItem = this.mMsgItem;
                if (aIOMsgItem != null && (bVar = this.mNTRelatedEmoticonManager) != null) {
                    bVar.c(aIOMsgItem, this.mCurType);
                }
                com.tencent.mobileqq.temp.report.a.a(this.mApp, "dc00898", "", this.mCurFriendUin, "0X800B11C", "0X800B11C", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        com.tencent.qqnt.emotion.relatedemo.a aVar = this.mEmotionExpandHelper;
        if (aVar != null) {
            aVar.onClosePanel();
        }
        this.mRecyclerView = null;
        this.mEmotionSearchAdapter = null;
        com.tencent.qqnt.emotion.relatedemo.logic.b bVar = this.mNTRelatedEmoticonManager;
        if (bVar != null) {
            bVar.b();
        }
        this.mNTRelatedEmoticonManager = null;
    }

    @Override // com.tencent.qqnt.emotion.relatedemo.m
    public void onError(int errorCode) {
        k kVar;
        List<EmotionPanelData> data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, errorCode);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NTRelatedEmotionPanel", 2, "onError.");
        }
        if (this.mRecyclerView != null && (kVar = this.mEmotionSearchAdapter) != null) {
            this.mLoadingStatus = 2;
            if (kVar != null) {
                boolean z16 = false;
                if (kVar != null && (data = kVar.getData()) != null && !data.isEmpty()) {
                    z16 = true;
                }
                if (z16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.e("NTRelatedEmotionPanel", 4, "load more error " + errorCode);
                    }
                    q();
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.e("NTRelatedEmotionPanel", 4, "first load error " + errorCode);
            }
            q();
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        l();
        com.tencent.qqnt.emotion.relatedemo.a aVar = this.mEmotionExpandHelper;
        if (aVar != null) {
            aVar.onClosePanel();
        }
        this.mRecyclerView = null;
        this.mEmotionSearchAdapter = null;
        com.tencent.qqnt.emotion.relatedemo.logic.b bVar = this.mNTRelatedEmoticonManager;
        if (bVar != null) {
            bVar.b();
        }
        this.mNTRelatedEmoticonManager = null;
    }

    public final void s(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull AIOMsgItem msgItem, @NotNull URLDrawable urlDrawable, int panelHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, aioContext, msgItem, urlDrawable, Integer.valueOf(panelHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        Dialog dialog = this.mSearchPanelDialog;
        if (dialog == null || !dialog.isShowing()) {
            z16 = false;
        }
        if (z16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AIORelatedEmotionPanelProvider", 4, "Panel isShowing, end showEmotionSearchWindow");
                return;
            }
            return;
        }
        if (this.mApp != null && (getContext() instanceof Activity)) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (!((Activity) context).isFinishing()) {
                this.mAioContext = aioContext;
                this.mMsgItem = msgItem;
                this.mCurFriendUin = String.valueOf(msgItem.getMsgRecord().peerUin);
                this.mCurType = aioContext.g().r().c().e();
                BaseQQAppInterface baseQQAppInterface = this.mApp;
                Intrinsics.checkNotNull(baseQQAppInterface);
                p(baseQQAppInterface, msgItem, urlDrawable);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                final RelatedEmoSlideBottomPanel relatedEmoSlideBottomPanel = new RelatedEmoSlideBottomPanel(context2, null, 0, 6, null);
                relatedEmoSlideBottomPanel.setContentHeight(panelHeight);
                relatedEmoSlideBottomPanel.setContentView(this);
                relatedEmoSlideBottomPanel.setCallback(new c());
                if (this.mSearchPanelDialog == null) {
                    this.mSearchPanelDialog = new ReportDialog(getContext(), R.style.f173448dl);
                }
                Dialog dialog2 = this.mSearchPanelDialog;
                if (dialog2 != null) {
                    dialog2.setContentView(relatedEmoSlideBottomPanel);
                    dialog2.setOnDismissListener(this);
                    dialog2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.qqnt.emotion.relatedemo.ui.a
                        @Override // android.content.DialogInterface.OnKeyListener
                        public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                            boolean t16;
                            t16 = NTRelatedEmotionPanel.t(RelatedEmoSlideBottomPanel.this, dialogInterface, i3, keyEvent);
                            return t16;
                        }
                    });
                    Window window = dialog2.getWindow();
                    if (window != null) {
                        int statusBarHeight = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels - ViewUtils.getStatusBarHeight(getContext());
                        if (statusBarHeight == 0) {
                            statusBarHeight = -1;
                        }
                        window.setLayout(-1, statusBarHeight);
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        attributes.gravity = 80;
                        window.setAttributes(attributes);
                    }
                    relatedEmoSlideBottomPanel.i();
                    dialog2.show();
                    return;
                }
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AIORelatedEmotionPanelProvider", 4, "mApp:" + this.mApp + ", end showEmotionSearchWindow\"");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NTRelatedEmotionPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            return;
        }
        iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ NTRelatedEmotionPanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NTRelatedEmotionPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mCurFriendUin = "";
        } else {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
