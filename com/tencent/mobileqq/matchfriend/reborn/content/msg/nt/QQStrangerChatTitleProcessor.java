package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerChatTitleProcessor;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "", "g", "", "status", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/w;", "tagBackgroundSpan", "i", "f", "", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "markList", "e", "Landroid/graphics/drawable/Drawable;", "drawable", "j", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerChatTitleProcessor extends com.tencent.qqnt.chats.inject.title.a {

    /* renamed from: b, reason: collision with root package name */
    private static final int f244665b = com.tencent.mobileqq.webview.view.b.e(21);

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerChatTitleProcessor$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.e("QQStrangerChatTitleProcessor", 1, "[handleIconUpdate] loadDrawable failed.");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            if (drawable == null) {
                return;
            }
            QQStrangerChatTitleProcessor.this.j(drawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(SingleLineTextView view, com.tencent.qqnt.chats.core.adapter.itemdata.g item, List<? extends QQStrangerInteractiveMarkModel> markList) {
        view.setIconDrawablePadding(0, (int) com.tencent.qqnt.chats.tmp.a.a());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = markList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((QQStrangerInteractiveMarkModel) next).level > 0) {
                arrayList2.add(next);
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            String e16 = com.tencent.mobileqq.matchfriend.reborn.mark.c.e((QQStrangerInteractiveMarkModel) it5.next());
            if (!URLUtil.isValidUrl(e16)) {
                QLog.e("QQStrangerChatTitleProcessor", 1, "[handleIconUpdate] iconUrl invalid: " + e16);
                view.setIconDrawables(null, false);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = new ColorDrawable(0);
                int i3 = f244665b;
                colorDrawable.setBounds(0, 0, i3, i3);
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mFailedDrawable = colorDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(e16, obtain);
                drawable.setURLDrawableListener(new b());
                drawable.setAutoDownload(true);
                drawable.startDownload(true);
                Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
                j(drawable);
                arrayList.add(drawable);
            }
        }
        if (!arrayList.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("QQStrangerChatTitleProcessor", 1, "[handleIconUpdate] drawableList size : " + arrayList.size() + ",  peerTinyId=" + item.k() + ", view=" + view.hashCode());
            }
            Object[] array = arrayList.toArray(new Drawable[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            view.setIconDrawables((Drawable[]) array, true);
            return;
        }
        view.setIconDrawables(null, false);
    }

    private final void f(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final SingleLineTextView view) {
        com.tencent.mobileqq.matchfriend.reborn.couple.b<? extends QQStrangerInteractiveMarkModel> coupleMgr = ((IQQStrangerInteractiveMarkService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQStrangerInteractiveMarkService.class, "")).getCoupleMgr(item.n());
        if (coupleMgr == null) {
            QLog.e("QQStrangerChatTitleProcessor", 1, "[handleInteractiveMark] but manager is null.");
        } else {
            coupleMgr.f(item.k(), new Function1<List<? extends QQStrangerInteractiveMarkModel>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerChatTitleProcessor$handleInteractiveMark$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends QQStrangerInteractiveMarkModel> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends QQStrangerInteractiveMarkModel> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    QQStrangerChatTitleProcessor.this.e(view, item, it);
                }
            });
        }
    }

    private final void g(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final SingleLineTextView view) {
        com.tencent.mobileqq.matchfriend.reborn.utils.o oVar = com.tencent.mobileqq.matchfriend.reborn.utils.o.f245489a;
        int b16 = oVar.b();
        int i3 = oVar.i();
        String b17 = item.w().b();
        if (b17 == null) {
            b17 = "";
        }
        if (Intrinsics.areEqual(b17, "\u5f53\u524d\u5728\u7ebf")) {
            b16 = Color.parseColor("#197459FF");
            i3 = Color.parseColor("#7459FF");
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        final w wVar = new w(context, b16, 20, 5, 0, 12, i3, b17);
        final String str = b17;
        view.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.k
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerChatTitleProcessor.h(QQStrangerChatTitleProcessor.this, item, view, str, wVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(QQStrangerChatTitleProcessor this$0, com.tencent.qqnt.chats.core.adapter.itemdata.g item, SingleLineTextView view, String status, w tagBackgroundSpan) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(status, "$status");
        Intrinsics.checkNotNullParameter(tagBackgroundSpan, "$tagBackgroundSpan");
        this$0.i(item, view, status, tagBackgroundSpan);
    }

    private final void i(com.tencent.qqnt.chats.core.adapter.itemdata.g item, SingleLineTextView view, String status, w tagBackgroundSpan) {
        String e16 = item.w().e();
        int width = view.getWidth();
        if (width > 0) {
            int compoundPaddingRight = view.getCompoundPaddingRight();
            int size = tagBackgroundSpan.getSize(new Paint(), "", 0, 0, null);
            float measureText = (((width - compoundPaddingRight) - size) - view.getPaint().measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX)) - com.tencent.mobileqq.webview.view.b.e(5);
            float measureText2 = view.getPaint().measureText(e16);
            if (measureText2 > measureText) {
                String substring = item.w().e().substring(0, view.getPaint().breakText(item.w().e(), true, measureText, null));
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                e16 = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQStrangerChatTitleProcessor", 1, "[handleTitle] viewWidth=" + width + ", paddingRight=" + compoundPaddingRight + ", tagLength=" + size + ", originNickWidth=" + measureText2 + ", remainWidth=" + measureText);
                }
            }
        } else {
            String e17 = item.w().e();
            String e18 = item.w().e();
            e16 = TextUtils.getNeoTextAfter(e17, 0, 9, true);
            Intrinsics.checkNotNullExpressionValue(e16, "getNeoTextAfter(nickText, 0, 9, true)");
            if ((e16.length() > 0) && e18.length() != e16.length()) {
                e16 = e16 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("QQStrangerChatTitleProcessor", 1, "[handleTitle] fallback.");
            }
        }
        SpannableString spannableString = new SpannableString(e16 + "  ");
        if (status.length() > 0) {
            spannableString.setSpan(tagBackgroundSpan, e16.length() + 1, e16.length() + 2, 33);
        }
        view.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0 && intrinsicWidth > 0) {
            int i3 = f244665b;
            intrinsicWidth = (intrinsicWidth * i3) / intrinsicHeight;
            intrinsicHeight = i3;
        }
        if (intrinsicHeight > 0 && intrinsicWidth > 0) {
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        } else {
            int i16 = f244665b;
            drawable.setBounds(0, 0, i16, i16);
        }
        drawable.invalidateSelf();
    }

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, SingleLineTextView view) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 104) {
            return;
        }
        view.setForMsgListDenoise(false);
        view.setExtendText("", 2);
        view.setExtendText(item.u(), 0);
        f(item, view);
        g(item, view);
        com.tencent.mobileqq.matchfriend.reborn.utils.o oVar = com.tencent.mobileqq.matchfriend.reborn.utils.o.f245489a;
        view.setTextColor(oVar.h());
        view.setExtendTextColor(oVar.f(), 0);
    }
}
