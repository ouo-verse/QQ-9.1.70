package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.text.SpannableString;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import fm1.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import sk1.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/UrlTextProcessor;", "Lpm1/a;", "Lorg/json/JSONObject;", "contentJson", "patternJson", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "Lkotlin/Function1;", "Landroid/widget/EditText;", "Lkotlin/jvm/functions/Function1;", "getFetchEditText", "()Lkotlin/jvm/functions/Function1;", "b", "(Lkotlin/jvm/functions/Function1;)V", "fetchEditText", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class UrlTextProcessor implements pm1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super RestoreInfo, ? extends EditText> fetchEditText = new Function1<RestoreInfo, EditText>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.UrlTextProcessor$fetchEditText$1
        @Override // kotlin.jvm.functions.Function1
        public final EditText invoke(@NotNull RestoreInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return (EditText) it.a().f().findViewById(R.id.wcw);
        }
    };

    @Override // pm1.a
    public void a(@NotNull JSONObject contentJson, @NotNull JSONObject patternJson, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(patternJson, "patternJson");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        JSONObject jSONObject = contentJson.getJSONObject("url_content");
        int optInt = jSONObject.optInt("type");
        String resUrl = jSONObject.optString("url");
        String displayText = jSONObject.optString("displayText");
        String mediaTaskId = jSONObject.optString("media_task_id");
        QLog.i("UrlTextProcessor", 1, "process type=" + optInt);
        if (optInt != 1 && optInt != 3) {
            switch (optInt) {
                case 6:
                    c.a aVar = c.a.f220905a;
                    JSONObject jSONObject2 = jSONObject.getJSONObject("third_share_info");
                    String imageUrl = jSONObject2.optString("image_url");
                    String title = jSONObject2.optString("title");
                    String optString = jSONObject2.optString("abstract");
                    String redirectUrl = jSONObject2.optString("redirect_url");
                    List<i> b16 = restoreResult.b();
                    Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(optString, "abstract");
                    Intrinsics.checkNotNullExpressionValue(redirectUrl, "redirectUrl");
                    Intrinsics.checkNotNullExpressionValue(mediaTaskId, "mediaTaskId");
                    b16.add(new fm1.a(imageUrl, title, optString, redirectUrl, mediaTaskId));
                    return;
                case 7:
                case 8:
                case 9:
                    c.b bVar = c.b.f220906a;
                    JSONObject jSONObject3 = jSONObject.getJSONObject("third_video_info");
                    String imageUrl2 = jSONObject3.optString("cover");
                    String pcJumpUrl = jSONObject3.optString("pc_jump_url");
                    String jumpUrl = jSONObject3.optString("jump_url");
                    List<i> b17 = restoreResult.b();
                    Intrinsics.checkNotNullExpressionValue(imageUrl2, "imageUrl");
                    Intrinsics.checkNotNullExpressionValue(pcJumpUrl, "pcJumpUrl");
                    Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
                    Intrinsics.checkNotNullExpressionValue(mediaTaskId, "mediaTaskId");
                    Intrinsics.checkNotNullExpressionValue(displayText, "displayText");
                    b17.add(new fm1.b(imageUrl2, pcJumpUrl, jumpUrl, optInt, mediaTaskId, displayText));
                    return;
                case 10:
                    int optInt2 = jSONObject.optInt("icon_type");
                    EditText invoke = this.fetchEditText.invoke(restoreInfo);
                    if (invoke == null) {
                        return;
                    }
                    invoke.measure(View.MeasureSpec.makeMeasureSpec(ScreenUtil.SCREEN_WIDTH, 1073741824), 0);
                    b.Companion companion = sk1.b.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(displayText, "displayText");
                    Intrinsics.checkNotNullExpressionValue(resUrl, "resUrl");
                    restoreResult.getMEditable().append((CharSequence) companion.c(optInt2, displayText, resUrl, invoke));
                    return;
                default:
                    return;
            }
        }
        EditText invoke2 = this.fetchEditText.invoke(restoreInfo);
        if (invoke2 == null) {
            return;
        }
        b.Companion companion2 = sk1.b.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(resUrl, "resUrl");
        sk1.b b18 = companion2.b(resUrl, invoke2);
        SpannableString spannableString = new SpannableString(resUrl);
        spannableString.setSpan(b18, 0, resUrl.length(), 33);
        restoreResult.getMEditable().append((CharSequence) spannableString);
    }

    public final void b(@NotNull Function1<? super RestoreInfo, ? extends EditText> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.fetchEditText = function1;
    }
}
