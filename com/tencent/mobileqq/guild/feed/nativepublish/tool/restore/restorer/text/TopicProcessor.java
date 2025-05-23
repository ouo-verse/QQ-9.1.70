package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text;

import android.text.Editable;
import android.text.SpannableString;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/TopicProcessor;", "Lpm1/a;", "Lorg/json/JSONObject;", "contentJson", "patternJson", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "a", "Lkotlin/Function1;", "Landroid/widget/EditText;", "Lkotlin/jvm/functions/Function1;", "getFetchEditText", "()Lkotlin/jvm/functions/Function1;", "setFetchEditText", "(Lkotlin/jvm/functions/Function1;)V", "fetchEditText", "<init>", "()V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicProcessor implements pm1.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f222264b = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function1<? super RestoreInfo, ? extends EditText> fetchEditText = new Function1<RestoreInfo, EditText>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.TopicProcessor$fetchEditText$1
        @Override // kotlin.jvm.functions.Function1
        public final EditText invoke(@NotNull RestoreInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return (EditText) it.a().f().findViewById(R.id.wcw);
        }
    };

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/text/TopicProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Override // pm1.a
    public void a(@NotNull JSONObject contentJson, @NotNull JSONObject patternJson, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(patternJson, "patternJson");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        JSONObject jSONObject = contentJson.getJSONObject("topic_content");
        long j3 = jSONObject.getLong("topic_id");
        String topicName = jSONObject.getString("topic_name");
        int optInt = jSONObject.optInt("show_status", 0);
        Intrinsics.checkNotNullExpressionValue(topicName, "topicName");
        if (topicName.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (restoreInfo.getIsFilterIllegalStateTopic() && optInt != 1 && optInt != 0) {
                if (restoreInfo.getIsFilterIllegalStateTopic() && optInt == 2) {
                    restoreResult.getMEditable().append((CharSequence) topicName);
                    return;
                }
                QLog.i("TopicProcessor", 1, "topicId=" + j3 + ", showStatus=" + optInt + " is filtered");
                return;
            }
            EditText invoke = this.fetchEditText.invoke(restoreInfo);
            if (invoke == null) {
                return;
            }
            int color = invoke.getContext().getColor(R.color.qui_common_brand_standard);
            Editable mEditable = restoreResult.getMEditable();
            SpannableString spannableString = new SpannableString(topicName);
            spannableString.setSpan(new yn1.b(j3, color), 0, spannableString.length(), 33);
            mEditable.append((CharSequence) spannableString);
            return;
        }
        QLog.i("TopicProcessor", 1, "process|topicName is empty!");
    }
}
