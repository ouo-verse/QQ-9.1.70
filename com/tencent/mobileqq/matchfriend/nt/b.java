package com.tencent.mobileqq.matchfriend.nt;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0003\u0012B+\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/nt/b;", "Lcom/tencent/mobileqq/text/QQText;", "", "a", "", "d", "Ljava/lang/String;", "sourceType", "", "source", "", WadlProxyConsts.FLAGS, "emosize", "", "message", "<init>", "(Ljava/lang/CharSequence;IILjava/lang/Object;)V", "e", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends QQText {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String sourceType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/nt/b$b;", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "url", "e", "sourceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.nt.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C8008b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String url;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final String sourceType;

        public C8008b(String url, String sourceType) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(sourceType, "sourceType");
            this.url = url;
            this.sourceType = sourceType;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            boolean startsWith$default;
            boolean startsWith$default2;
            Intrinsics.checkNotNullParameter(widget, "widget");
            QLog.d("MatchFriendNTQQText", 1, "MatchFriendLinkSpan onClick:" + this.url);
            Context context = widget.getContext();
            if (context == null || TextUtils.isEmpty(this.url)) {
                return;
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.url, "http", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(this.url, "https", false, 2, null);
                if (!startsWith$default2) {
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
                    ax c16 = bi.c((BaseQQAppInterface) runtime, context, this.url);
                    if (c16 != null) {
                        c16.b();
                    }
                    ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).matchFriendOfficialMessageReport(context, "dt_clck", this.sourceType);
                }
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.url);
            context.startActivity(intent);
            ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).matchFriendOfficialMessageReport(context, "dt_clck", this.sourceType);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ds5.linkColor);
            ds5.clearShadowLayer();
        }
    }

    public b(CharSequence charSequence, int i3, int i16, Object obj) {
        super(charSequence, i3, i16, obj);
        this.sourceType = "0";
        a();
    }

    private final void a() {
        int indexOf$default;
        String replace$default;
        try {
            for (Pair<String, String> pair : ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).parseMatchFriendQQText(this.mText)) {
                String url = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).parseMatchFriendUrl((String) pair.first);
                String mText = this.mText;
                Intrinsics.checkNotNullExpressionValue(mText, "mText");
                Object obj = pair.first;
                Intrinsics.checkNotNullExpressionValue(obj, "pair.first");
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) mText, (String) obj, 0, false, 6, (Object) null);
                if (indexOf$default >= 0) {
                    String mText2 = this.mText;
                    Intrinsics.checkNotNullExpressionValue(mText2, "mText");
                    Object obj2 = pair.first;
                    Intrinsics.checkNotNullExpressionValue(obj2, "pair.first");
                    Object obj3 = pair.second;
                    Intrinsics.checkNotNullExpressionValue(obj3, "pair.second");
                    replace$default = StringsKt__StringsJVMKt.replace$default(mText2, (String) obj2, (String) obj3, false, 4, (Object) null);
                    this.mText = replace$default;
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    addSpan(new C8008b(url, this.sourceType), indexOf$default, ((String) pair.second).length() + indexOf$default, 33);
                }
            }
            this.mSource = this.mText;
        } catch (Exception e16) {
            QLog.e("MatchFriendNTQQText", 1, "MatchFriendNTQQText init error", e16);
            this.mText = this.mSource;
        }
    }
}
