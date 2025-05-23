package com.tencent.guild.aio.util;

import android.util.Log;
import com.tencent.guild.aio.msglist.markdown.LinkSpanEntity;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/util/i;", "", "", "content", "Ljava/util/ArrayList;", "Lcom/tencent/guild/aio/msglist/markdown/e;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f112408a = new i();

    i() {
    }

    @NotNull
    public final ArrayList<LinkSpanEntity> a(@NotNull String content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList<LinkSpanEntity> arrayList = new ArrayList<>();
        if (content.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && content.length() <= 1000) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList<LinkSpanEntity> arrayList2 = new ArrayList<>();
            Matcher matcher = cg.f307530i.matcher(content);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String substring = content.substring(start, end);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                arrayList2.add(new LinkSpanEntity(substring, start, end));
            }
            if (true ^ arrayList2.isEmpty()) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildNumberParseLinkUtil", "[parseLinkSpan] cost=" + (System.currentTimeMillis() - currentTimeMillis) + " ms, content=" + content + " ");
                }
            }
            return arrayList2;
        }
        return arrayList;
    }
}
