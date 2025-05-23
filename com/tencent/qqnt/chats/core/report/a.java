package com.tencent.qqnt.chats.core.report;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chats/core/report/a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$g;", "unreadInfo", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$UnreadType;", "f", "", "contactType", "", "isTroopGuild", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$ChatType;", "a", "top", "e", "clickId", "d", "type", "Lcom/tencent/qqnt/chats/core/report/DTChatsConst$PageType;", "b", "", "Lcom/tencent/qqnt/chats/api/b$c;", "marks", "Lcom/tencent/qqnt/chats/core/report/data/c;", "c", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, h.F, "", "g", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f354861a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f354861a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final DTChatsConst.ChatType a(int contactType, boolean isTroopGuild) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DTChatsConst.ChatType) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(contactType), Boolean.valueOf(isTroopGuild));
        }
        if (contactType != 1) {
            if (contactType != 2) {
                if (contactType != 4) {
                    if (contactType != 9) {
                        if (contactType != 16) {
                            if (contactType != 30) {
                                if (contactType != 103) {
                                    if (contactType != 118) {
                                        if (contactType != 99 && contactType != 100) {
                                            return DTChatsConst.ChatType.OTHER;
                                        }
                                        return DTChatsConst.ChatType.TEMP;
                                    }
                                    return DTChatsConst.ChatType.SERVICE_ASSISTANT;
                                }
                                return DTChatsConst.ChatType.PUBLIC_ACCOUNT;
                            }
                            return DTChatsConst.ChatType.PUBLIC_ACCOUNT_ASSISTANT;
                        }
                        return DTChatsConst.ChatType.GUILD;
                    }
                    return DTChatsConst.ChatType.TROOP_GUILD;
                }
                return DTChatsConst.ChatType.SUB_GUILD;
            }
            if (isTroopGuild) {
                return DTChatsConst.ChatType.TROOP_GUILD;
            }
            return DTChatsConst.ChatType.TROOP;
        }
        return DTChatsConst.ChatType.C2C;
    }

    @NotNull
    public final DTChatsConst.PageType b(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DTChatsConst.PageType) iPatchRedirector.redirect((short) 6, (Object) this, type);
        }
        if (type != 1) {
            if (type != 2) {
                if (type != 3 && type != 4) {
                    if (type != 6) {
                        if (type != 9) {
                            return DTChatsConst.PageType.OTHER;
                        }
                        return DTChatsConst.PageType.GUILD_HELPER;
                    }
                    return DTChatsConst.PageType.HIDDEN_LIST;
                }
                return DTChatsConst.PageType.MINI_AIO;
            }
            return DTChatsConst.PageType.TROOP_HELPER;
        }
        return DTChatsConst.PageType.MAIN;
    }

    @Nullable
    public final com.tencent.qqnt.chats.core.report.data.c c(@NotNull List<b.c> marks) {
        int lastIndex;
        int lastIndex2;
        int lastIndex3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.chats.core.report.data.c) iPatchRedirector.redirect((short) 7, (Object) this, (Object) marks);
        }
        Intrinsics.checkNotNullParameter(marks, "marks");
        if (marks.isEmpty()) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        for (b.c cVar : marks) {
            sb5.append(cVar.c());
            sb5.append(",");
            sb6.append(cVar.a());
            sb6.append(",");
            sb7.append(cVar.b());
            sb7.append(",");
        }
        lastIndex = StringsKt__StringsKt.getLastIndex(sb5);
        sb5.deleteCharAt(lastIndex);
        lastIndex2 = StringsKt__StringsKt.getLastIndex(sb6);
        sb6.deleteCharAt(lastIndex2);
        lastIndex3 = StringsKt__StringsKt.getLastIndex(sb7);
        sb7.deleteCharAt(lastIndex3);
        String sb8 = sb6.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "levelBuilder.toString()");
        String sb9 = sb7.toString();
        Intrinsics.checkNotNullExpressionValue(sb9, "subLevelBuilder.toString()");
        String sb10 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb10, "typeBuilder.toString()");
        return new com.tencent.qqnt.chats.core.report.data.c(sb8, sb9, sb10);
    }

    public final int d(int clickId) {
        boolean z16;
        DTChatsConst.MenuAction menuAction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, clickId)).intValue();
        }
        if (clickId == R.id.epz) {
            menuAction = DTChatsConst.MenuAction.DEL;
        } else if (clickId == R.id.eqb) {
            menuAction = DTChatsConst.MenuAction.SET_UNREAD;
        } else {
            boolean z17 = false;
            if (clickId == R.id.eqe || clickId == R.id.eqj) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                menuAction = DTChatsConst.MenuAction.SET_TOP;
            } else if (clickId == R.id.epu) {
                menuAction = DTChatsConst.MenuAction.CANCEL_TOP;
            } else if (clickId == R.id.eqa) {
                menuAction = DTChatsConst.MenuAction.SET_READ;
            } else if (clickId == R.id.z4b) {
                menuAction = DTChatsConst.MenuAction.CANCEL_FOLLOW;
            } else {
                if (clickId == R.id.eqo || clickId == R.id.z3n) {
                    z17 = true;
                }
                if (z17) {
                    menuAction = DTChatsConst.MenuAction.CANCEL_SUBSCRIBE;
                } else if (clickId == R.id.z49) {
                    menuAction = DTChatsConst.MenuAction.MSG_NO_DISTURB;
                } else if (clickId == R.id.z3l) {
                    menuAction = DTChatsConst.MenuAction.CANCEL_MSG_NO_DISTURB;
                } else if (clickId == R.id.z3x) {
                    menuAction = DTChatsConst.MenuAction.FOLD_GUILD;
                } else if (clickId == R.id.z3k) {
                    menuAction = DTChatsConst.MenuAction.CANCEL_FOLD_GUILD;
                } else {
                    menuAction = DTChatsConst.MenuAction.OTHER;
                }
            }
        }
        return menuAction.ordinal() + 1;
    }

    public final int e(boolean top) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null) {
            return top ? 1 : 0;
        }
        if (iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, top)).intValue();
        }
        return top ? 1 : 0;
    }

    @NotNull
    public final DTChatsConst.UnreadType f(@NotNull g.C9572g unreadInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DTChatsConst.UnreadType) iPatchRedirector.redirect((short) 2, (Object) this, (Object) unreadInfo);
        }
        Intrinsics.checkNotNullParameter(unreadInfo, "unreadInfo");
        if (unreadInfo.b() == 0) {
            return DTChatsConst.UnreadType.NONE;
        }
        int c16 = unreadInfo.c();
        if (c16 != 1) {
            if (c16 != 2) {
                if (c16 != 3) {
                    return DTChatsConst.UnreadType.NONE;
                }
                return DTChatsConst.UnreadType.DOT_RED;
            }
            return DTChatsConst.UnreadType.GRAY;
        }
        return DTChatsConst.UnreadType.RED;
    }

    @NotNull
    public final String g(@NotNull g item) {
        List split$default;
        int i3;
        String replace$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.s().guildContactInfo == null) {
            return "";
        }
        String str = item.s().guildContactInfo.unreadCntInfo.relatedToMeString;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.guildCon\u2026CntInfo.relatedToMeString");
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"]"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = split$default.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            if (str2.length() > 0) {
                i3 = 1;
            }
            if (i3 != 0) {
                replace$default = StringsKt__StringsJVMKt.replace$default(str2, "[", "", false, 4, (Object) null);
                arrayList.add(replace$default);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i3 < size) {
                sb5.append((String) arrayList.get(i3));
                if (i3 < arrayList.size() - 1) {
                    sb5.append(",");
                }
                i3++;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "reportStringBuilder.toString()");
        return sb6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int h(@NotNull g item) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) item)).intValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Map<LiteBusinessType, Object> i3 = item.i();
        boolean z16 = true;
        if (i3 != null && !i3.isEmpty()) {
            b16 = false;
        } else {
            b16 = true;
        }
        if (b16 != false) {
            return 0;
        }
        LiteBusinessType liteBusinessType = LiteBusinessType.KREVEAL;
        com.tencent.qqnt.chats.biz.bean.c cVar = null;
        com.tencent.qqnt.chats.biz.bean.b bVar = null;
        if (item.A(liteBusinessType) && !((IOnlineStatusChatsHelper) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IOnlineStatusChatsHelper.class)).canOnlineStatusRevealShow(item)) {
            Object obj = i3.get(liteBusinessType);
            if (obj instanceof com.tencent.qqnt.chats.biz.bean.b) {
                bVar = (com.tencent.qqnt.chats.biz.bean.b) obj;
            }
            if (bVar == null) {
                return 0;
            }
            long a16 = bVar.a();
            if (a16 == 2) {
                return 2;
            }
            if (a16 == 12) {
                return 1;
            }
            return 0;
        }
        LiteBusinessType liteBusinessType2 = LiteBusinessType.KLIGHTRINGREVEAL;
        if (!item.A(liteBusinessType2)) {
            return 0;
        }
        Object obj2 = i3.get(liteBusinessType2);
        if (obj2 instanceof com.tencent.qqnt.chats.biz.bean.c) {
            cVar = (com.tencent.qqnt.chats.biz.bean.c) obj2;
        }
        if (cVar == null) {
            return 0;
        }
        if (cVar.b().length() != 0) {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        long a17 = cVar.a();
        if (a17 == 2) {
            return 2;
        }
        if (a17 != 12) {
            return 0;
        }
        return 3;
    }
}
