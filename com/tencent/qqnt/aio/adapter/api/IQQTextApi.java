package com.tencent.qqnt.aio.adapter.api;

import android.text.Editable;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.QQTextBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J8\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createNewQQTextForStreamMsg", "", "qqText", "start", "", "end", "getInputNotReuseQQTextBuilder", "Landroid/text/Editable$Factory;", "getInputQQTextBuilder", "getQQText", "content", WadlProxyConsts.FLAGS, "emoSize", "view", "Landroid/view/View;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "getQQTextPurePlainText", "measureNickNameQQText", "", "setBizSrc", "", "src", "", "toPlainText", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IQQTextApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/api/IQQTextApi$a$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.adapter.api.IQQTextApi$a$a */
        /* loaded from: classes23.dex */
        public static final class C9446a extends Editable.Factory {
            static IPatchRedirector $redirector_;

            C9446a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.text.Editable.Factory
            @NotNull
            public Editable newEditable(@NotNull CharSequence source) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
                }
                Intrinsics.checkNotNullParameter(source, "source");
                return new QQTextBuilder(source, 3, 19);
            }
        }

        @NotNull
        public static Editable.Factory a(@NotNull IQQTextApi iQQTextApi) {
            return new C9446a();
        }

        @NotNull
        public static Editable.Factory b(@NotNull IQQTextApi iQQTextApi) {
            Editable.Factory EMOTION_INPUT_FACTORY = QQTextBuilder.EMOTION_INPUT_FACTORY;
            Intrinsics.checkNotNullExpressionValue(EMOTION_INPUT_FACTORY, "EMOTION_INPUT_FACTORY");
            return EMOTION_INPUT_FACTORY;
        }

        public static /* synthetic */ CharSequence c(IQQTextApi iQQTextApi, CharSequence charSequence, int i3, int i16, View view, AIOMsgItem aIOMsgItem, int i17, Object obj) {
            View view2;
            AIOMsgItem aIOMsgItem2;
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    view2 = null;
                } else {
                    view2 = view;
                }
                if ((i17 & 16) != 0) {
                    aIOMsgItem2 = null;
                } else {
                    aIOMsgItem2 = aIOMsgItem;
                }
                return iQQTextApi.getQQText(charSequence, i3, i16, view2, aIOMsgItem2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getQQText");
        }

        @NotNull
        public static CharSequence d(@NotNull IQQTextApi iQQTextApi, @NotNull CharSequence content, int i3) {
            Intrinsics.checkNotNullParameter(content, "content");
            return content;
        }

        public static float e(@NotNull IQQTextApi iQQTextApi, @NotNull CharSequence content, int i3) {
            Intrinsics.checkNotNullParameter(content, "content");
            return 0.0f;
        }

        public static void f(@NotNull IQQTextApi iQQTextApi, @NotNull CharSequence content, @NotNull String src) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(src, "src");
        }

        @NotNull
        public static CharSequence g(@NotNull IQQTextApi iQQTextApi, @NotNull CharSequence content, int i3) {
            Intrinsics.checkNotNullParameter(content, "content");
            return content;
        }
    }

    @NotNull
    CharSequence createNewQQTextForStreamMsg(@NotNull CharSequence qqText, int start, int end);

    @NotNull
    Editable.Factory getInputNotReuseQQTextBuilder();

    @NotNull
    Editable.Factory getInputQQTextBuilder();

    @NotNull
    CharSequence getQQText(@NotNull CharSequence content, int r26, int emoSize, @Nullable View view, @Nullable AIOMsgItem msgItem);

    @NotNull
    CharSequence getQQTextPurePlainText(@NotNull CharSequence content, int r26);

    float measureNickNameQQText(@NotNull CharSequence content, int emoSize);

    void setBizSrc(@NotNull CharSequence content, @NotNull String src);

    @NotNull
    CharSequence toPlainText(@NotNull CharSequence content, int r26);
}
