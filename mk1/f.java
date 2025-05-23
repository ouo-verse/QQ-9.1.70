package mk1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.guild.feed.gallery.pb.GuildFeedRecommendParam$ItemCbData;
import com.tencent.mobileqq.guild.feed.gallery.utils.ExposeData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.ak;
import com.tencent.mobileqq.qqguildsdk.data.genc.al;
import com.tencent.mobileqq.qqguildsdk.data.genc.cx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.em;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lmk1/f;", "", "", "feedInfos", "stage", "", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f416899a = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"mk1/f$a", "Lwh2/em;", "", "result", "", "errMsg", "", "onResult", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements em {
        a() {
        }

        @Override // wh2.em
        public void onResult(int result, @Nullable String errMsg) {
            if (result != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "exposeList result: " + result + ", errMsg:" + errMsg;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedsExposeHelper", 1, (String) it.next(), null);
                }
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildFeedsExposeHelper", 2, "exposeList success");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"mk1/f$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/tencent/mobileqq/guild/feed/gallery/utils/ExposeData;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends TypeToken<List<? extends ExposeData>> {
        b() {
        }
    }

    f() {
    }

    public final void a(@NotNull String feedInfos, @NotNull String stage) {
        String str;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(feedInfos, "feedInfos");
        Intrinsics.checkNotNullParameter(stage, "stage");
        Object fromJson = new Gson().fromJson(feedInfos, new b().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(feedInfo\u2026ExposeData?>?>() {}.type)");
        ArrayList<ak> arrayList = new ArrayList<>();
        for (ExposeData exposeData : (List) fromJson) {
            ak akVar = new ak();
            akVar.d(exposeData.getFeedId());
            byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(exposeData.getBusiReport(), 0);
            GuildFeedRecommendParam$ItemCbData guildFeedRecommendParam$ItemCbData = new GuildFeedRecommendParam$ItemCbData();
            byte[] bArr2 = new byte[0];
            try {
                guildFeedRecommendParam$ItemCbData.mergeFrom(decode);
                str = guildFeedRecommendParam$ItemCbData.stat_data.get();
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "itemCbData.stat_data.get() ?: \"\"");
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                str = "";
            }
            try {
                ByteStringMicro byteStringMicro = guildFeedRecommendParam$ItemCbData.cb_ext_data.get();
                if (byteStringMicro != null) {
                    bArr = byteStringMicro.toByteArray();
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr2 = new byte[0];
                } else {
                    Intrinsics.checkNotNullExpressionValue(bArr, "itemCbData.cb_ext_data.g\u2026teArray() ?: ByteArray(0)");
                    bArr2 = bArr;
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildFeedsExposeHelper", 2, "[tryToDoExpose] mergeFrom with Exception: " + e + ", busReport = " + decode);
                }
                akVar.c(new cx());
                akVar.a().d(str);
                akVar.a().c(bArr2);
                arrayList.add(akVar);
            }
            akVar.c(new cx());
            akVar.a().d(str);
            akVar.a().c(bArr2);
            arrayList.add(akVar);
        }
        if (arrayList.isEmpty()) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildFeedsExposeHelper", 2, "[exposeInternal] exposeList is empty ");
                return;
            }
            return;
        }
        al alVar = new al();
        Logger logger3 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger3.d().d("GuildFeedsExposeHelper", 2, "[exposeInternal] size:" + arrayList.size());
        }
        alVar.e(arrayList);
        alVar.f(stage);
        ((IGPSService) ch.R0(IGPSService.class)).exposeRecommends(alVar, new a());
    }
}
