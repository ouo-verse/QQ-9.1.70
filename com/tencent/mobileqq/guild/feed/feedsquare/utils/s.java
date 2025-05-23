package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u001a4\u0010\r\u001a\u00020\f*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00000\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n\u001a,\u0010\u0010\u001a\u00020\f*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00000\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u000f\u001a$\u0010\u0013\u001a\u00020\f*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00000\u00072\u0006\u0010\u0012\u001a\u00020\u0011\u001a$\u0010\u0015\u001a\u00020\f*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00000\u00072\u0006\u0010\u000b\u001a\u00020\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "type", "", "a", "Landroidx/lifecycle/MutableLiveData;", "", "newFeedList", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/n;", "args", "", "c", "modifyFeed", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/p;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/q;", "argsV2", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/b;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class s {
    public static final boolean a(@NotNull UIStateData<List<ij1.g>> uIStateData, @NotNull UIStateDataUtils.InsertType type) {
        Object m476constructorimpl;
        byte[] extraType;
        Intrinsics.checkNotNullParameter(uIStateData, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean z16 = false;
            if (uIStateData.getState() == 8 && (extraType = uIStateData.getExtraType()) != null) {
                Intrinsics.checkNotNullExpressionValue(extraType, "extraType");
                if (((UIStateDataUtils.UIStateDataInsertType) new Gson().fromJson(new String(extraType, Charsets.UTF_8), UIStateDataUtils.UIStateDataInsertType.class)).getType() == type) {
                    z16 = true;
                }
            }
            m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(z16));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m476constructorimpl).booleanValue();
    }

    public static final void b(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> mutableLiveData, @NotNull DeleteFeedArgs args) {
        List<ij1.g> mutableList;
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        UIStateData<List<ij1.g>> value = mutableLiveData.getValue();
        if (value != null) {
            List<ij1.g> data = value.getData();
            if (data != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (!args.a().invoke((ij1.g) obj).booleanValue()) {
                        arrayList.add(obj);
                    }
                }
                value.setState(6);
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                value.setDataList(mutableList);
                value.setExtraByte(new byte[0]);
            }
            mutableLiveData.setValue(value);
        }
    }

    public static final void c(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> mutableLiveData, @NotNull List<? extends ij1.g> newFeedList, @NotNull InsertFeedArgs args) {
        UIStateData<List<ij1.g>> value;
        int collectionSizeOrDefault;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        Intrinsics.checkNotNullParameter(newFeedList, "newFeedList");
        Intrinsics.checkNotNullParameter(args, "args");
        if ((!newFeedList.isEmpty()) && (value = mutableLiveData.getValue()) != null) {
            if (value.getData() == null) {
                value.setDataList(new ArrayList());
            }
            List<ij1.g> feedData = value.getData();
            if (args.c() != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : newFeedList) {
                    Intrinsics.checkNotNullExpressionValue(feedData, "feedData");
                    Iterator<T> it = feedData.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (args.c().invoke((ij1.g) obj).booleanValue()) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    if (obj == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj2);
                    }
                }
                newFeedList = arrayList;
            }
            if (newFeedList.isEmpty()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("onInsertFeed filterNewFeedList isEmpty");
                Iterator<T> it5 = bVar.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("UIStateDataUtils", 1, (String) it5.next(), null);
                }
                return;
            }
            if (feedData.size() >= args.getIndex()) {
                feedData.addAll(args.getIndex(), newFeedList);
            } else {
                feedData.addAll(newFeedList);
            }
            value.setState(8);
            value.setDataList(feedData);
            value.setExtraByte(UIStateDataUtils.f219309a.a(args.getInsertType()));
            if (args.getScrollPos() != -1) {
                value.setPos(args.getScrollPos());
            }
            jj1.b c16 = jj1.b.c();
            List<? extends ij1.g> list = newFeedList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it6 = list.iterator();
            while (it6.hasNext()) {
                arrayList2.add(((ij1.g) it6.next()).b());
            }
            c16.initOrUpdateGlobalState((List) arrayList2, true);
            mutableLiveData.setValue(value);
        }
    }

    public static final void d(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> mutableLiveData, @NotNull ModifyFeedArgsV2 argsV2) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        Intrinsics.checkNotNullParameter(argsV2, "argsV2");
        UIStateData<List<ij1.g>> value = mutableLiveData.getValue();
        if (value != null) {
            List<ij1.g> data = value.getData();
            if (data != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                Iterator<ij1.g> it = data.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (argsV2.b().invoke(it.next()).booleanValue()) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 < 0) {
                    Logger.f235387a.d().i("UIStateDataUtils", 1, "onModifyFeed not find");
                    return;
                }
                ij1.g clone = data.get(i3).clone();
                Intrinsics.checkNotNullExpressionValue(clone, "this.clone()");
                argsV2.a().invoke(clone);
                data.remove(i3);
                data.add(i3, clone);
                value.setState(7);
                value.setDataList(data);
                value.setExtraByte(new byte[0]);
                jj1.b.c().initOrUpdateGlobalState((jj1.b) clone.b(), true);
            }
            mutableLiveData.setValue(value);
        }
    }

    public static final void e(@NotNull MutableLiveData<UIStateData<List<ij1.g>>> mutableLiveData, @NotNull ij1.g modifyFeed, @NotNull ModifyFeedArgs args) {
        Object obj;
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        Intrinsics.checkNotNullParameter(modifyFeed, "modifyFeed");
        Intrinsics.checkNotNullParameter(args, "args");
        UIStateData<List<ij1.g>> value = mutableLiveData.getValue();
        if (value != null) {
            List<ij1.g> data = value.getData();
            if (data != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                Iterator<ij1.g> it = data.iterator();
                int i3 = 0;
                while (true) {
                    if (it.hasNext()) {
                        if (args.c().invoke(it.next()).booleanValue()) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    data.remove(i3);
                } else {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "onModifyFeed not find idd:" + modifyFeed.b().idd;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it5 = bVar.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("UIStateDataUtils", 1, (String) it5.next(), null);
                    }
                    if (!args.getActionWhenNotExist()) {
                        return;
                    } else {
                        i3 = 0;
                    }
                }
                Iterator<T> it6 = data.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        obj = it6.next();
                        if (args.b().invoke((ij1.g) obj).booleanValue()) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (obj == null) {
                    data.add(i3, modifyFeed);
                    value.setState(7);
                    value.setDataList(data);
                    value.setExtraByte(new byte[0]);
                    jj1.b.c().initOrUpdateGlobalState((jj1.b) modifyFeed.b(), true);
                } else {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar2 = new Logger.b();
                    String str2 = "onModifyFeed addPredicate return true idd:" + modifyFeed.b().idd;
                    if (str2 instanceof String) {
                        bVar2.a().add(str2);
                    }
                    Iterator<T> it7 = bVar2.a().iterator();
                    while (it7.hasNext()) {
                        Logger.f235387a.d().e("UIStateDataUtils", 1, (String) it7.next(), null);
                    }
                    return;
                }
            }
            mutableLiveData.setValue(value);
        }
    }
}
