package com.tencent.mobileqq.emoticonview.ai.emoticon.album;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.a;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.MediaMimeType;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.TabType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/ai/emoticon/album/AiEmoticonAlbumUtils;", "", "()V", "MAX_SELECT_NUM", "", "MEDIA_ITEM_SPAN_COUNT", "", "getAiEmoticonAlbumIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "maxMediaSize", "getQueryMediaFilter", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class AiEmoticonAlbumUtils {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final AiEmoticonAlbumUtils INSTANCE;

    @NotNull
    public static final String MAX_SELECT_NUM = "AI_EMOTICON_MAX_SELECT_NUM";
    public static final int MEDIA_ITEM_SPAN_COUNT = 4;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19887);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new AiEmoticonAlbumUtils();
        }
    }

    AiEmoticonAlbumUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MediaFilter getQueryMediaFilter() {
        List<? extends MediaMimeType> listOf;
        MediaFilter.Companion companion = MediaFilter.INSTANCE;
        MediaFilter.a aVar = new MediaFilter.a();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MediaMimeType[]{MediaMimeType.IMAGE_JPEG, MediaMimeType.IMAGE_PNG, MediaMimeType.IMAGE_GIF, MediaMimeType.IMAGE_WEBP, MediaMimeType.IMAGE_HEIF});
        aVar.e(listOf);
        return aVar.a();
    }

    @NotNull
    public final Intent getAiEmoticonAlbumIntent(@NotNull Context context, int maxMediaSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, maxMediaSize);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        a aVar = a.f360732a;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.g(maxMediaSize);
        aVar2.i(1);
        aVar2.f(TabType.TAB_IMAGE);
        aVar2.h(4);
        aVar2.b(new ArrayList());
        aVar2.d(false);
        aVar2.l(false);
        aVar2.n(INSTANCE.getQueryMediaFilter());
        aVar2.j(true);
        aVar2.e(10000001);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PickerInitBean.Companion companion2 = PickerInitBean.INSTANCE;
        PickerInitBean.a aVar3 = new PickerInitBean.a();
        String string = context.getString(R.string.b2e);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString( R.string.f_emosm_finish)");
        aVar3.b(string);
        Intent d16 = aVar.d(context, a16, aVar3.a(), AiEmoticonPickerCustomization.class, AiEmoticonPreviewCustomization.class);
        d16.putExtra(MAX_SELECT_NUM, maxMediaSize);
        return d16;
    }
}
