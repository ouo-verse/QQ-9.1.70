package com.tencent.mobileqq.wink.schema;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.event.RemovePickerBannerBarEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JJ\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062&\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/SchemaHelper;", "", "Landroid/content/Intent;", "intent", "", "c", "", "targetSongId", "b", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "keyAttrs", "", "keysToRemove", "d", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "", "e", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class SchemaHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SchemaHelper f326270a = new SchemaHelper();

    SchemaHelper() {
    }

    private final boolean b(Intent intent, String targetSongId) {
        HashMap hashMap;
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        String str = null;
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            str = (String) hashMap.get("music");
        }
        return Intrinsics.areEqual(str, targetSongId);
    }

    private final boolean c(Intent intent) {
        HashMap hashMap;
        boolean z16;
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && hashMap.containsKey("music") && hashMap.containsKey("meterial")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(String url, HashMap<String, String> keyAttrs, Set<String> keysToRemove) {
        Uri parse = Uri.parse(url);
        Uri.Builder clearQuery = parse.buildUpon().clearQuery();
        if (keysToRemove != null) {
            for (String str : keysToRemove) {
                if (keyAttrs != null) {
                    keyAttrs.remove(str);
                }
            }
        }
        for (String str2 : parse.getQueryParameterNames()) {
            if (keysToRemove == null || !keysToRemove.contains(str2)) {
                clearQuery.appendQueryParameter(str2, parse.getQueryParameter(str2));
            }
        }
        String uri = clearQuery.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "uriBuilder.build().toString()");
        return uri;
    }

    public final void e(@NotNull FragmentActivity activity, @Nullable WinkEditorMusicInfo musicInfo) {
        final HashMap hashMap;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intent = activity.getIntent();
        if (intent == null || !c(intent)) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        Unit unit = null;
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.schema.SchemaHelper$removeMusicScheme$removeMusicAttributes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Set of5;
                String d16;
                WinkContext.Companion companion = WinkContext.INSTANCE;
                WinkContext d17 = companion.d();
                SchemaHelper schemaHelper = SchemaHelper.f326270a;
                String schemaString = companion.d().getSchemaString();
                HashMap<String, String> hashMap2 = hashMap;
                of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"music", QCircleScheme.AttrQQPublish.MUSIC_LOADING_TITLE});
                d16 = schemaHelper.d(schemaString, hashMap2, of5);
                d17.z(d16);
                w53.b.f("SchemaHelper", "[removeMusicScheme] remove music " + companion.d().getSchemaString());
                SimpleEventBus.getInstance().dispatchEvent(new RemovePickerBannerBarEvent());
            }
        };
        if (musicInfo != null) {
            SchemaHelper schemaHelper = f326270a;
            String p16 = musicInfo.p();
            Intrinsics.checkNotNullExpressionValue(p16, "it.songMid");
            if (!schemaHelper.b(intent, p16)) {
                function0.invoke();
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            function0.invoke();
        }
    }
}
