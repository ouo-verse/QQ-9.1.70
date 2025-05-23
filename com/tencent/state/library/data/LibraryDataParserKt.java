package com.tencent.state.library.data;

import android.app.Application;
import android.graphics.Point;
import android.util.Size;
import bs4.b;
import bs4.e;
import bs4.g;
import bs4.h;
import bs4.i;
import bs4.j;
import bs4.k;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.common.tag.DialogTagSetInfo;
import com.tencent.state.common.tag.TagCategoryInfo;
import com.tencent.state.data.Image;
import com.tencent.state.data.UserCommon;
import com.tencent.state.map.Location;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.CommonConfig;
import com.tencent.state.template.data.CommonDataParserKt;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.Decorator;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.data.UserStatus;
import hs4.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
import rs4.f;
import rs4.n;
import us4.a;
import us4.c;
import us4.d;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0005*\u00020\u0004\u001a\u0012\u0010\u0002\u001a\u00020\t*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007\u001a\n\u0010\u0002\u001a\u00020\u000b*\u00020\n\u001a\u0012\u0010\u0002\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r\u001a\n\u0010\u0002\u001a\u00020\u0011*\u00020\u0010\u001a\n\u0010\u0002\u001a\u00020\u0013*\u00020\u0012\u001a\n\u0010\u0002\u001a\u00020\u0015*\u00020\u0014\u001a\n\u0010\u0002\u001a\u00020\u0017*\u00020\u0016\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\u0004\b\u0002\u0010\u001b\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u001a*\u00020\u0019\u001a\n\u0010\u001e\u001a\u00020\u001d*\u00020\u001c\u001a\n\u0010!\u001a\u00020 *\u00020\u001f\u001a\n\u0010\u0002\u001a\u00020#*\u00020\"\"\u0014\u0010%\u001a\u00020$8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006'"}, d2 = {"Lrs4/f;", "Lcom/tencent/state/template/data/EnterRoomInfo;", "parse", "Lrs4/n;", "Lbs4/f;", "Lcom/tencent/state/template/data/CommonRoomInfo;", "Lbs4/g;", "Landroid/util/Size;", "mapSize", "Lcom/tencent/state/template/data/Table;", "Lbs4/j;", "Lcom/tencent/state/template/data/User;", "Lbs4/k;", "", "uin", "Lcom/tencent/state/data/UserCommon;", "Lbs4/c;", "Lcom/tencent/state/data/Image;", "Lbs4/b;", "Lcom/tencent/state/template/data/SitDownInfo;", "Lbs4/h;", "Lcom/tencent/state/common/tag/CommonTagInfo;", "Lbs4/a;", "Landroid/graphics/Point;", "", "Lbs4/i;", "Lcom/tencent/state/template/data/RoomConfig;", "([Lbs4/i;)Lcom/tencent/state/template/data/RoomConfig;", "Lus4/a;", "Lcom/tencent/state/common/tag/TagCategoryInfo;", "toLibraryTagInfo", "Lus4/c;", "Lcom/tencent/state/common/tag/DialogTagSetInfo;", "toDialogTagSetInfo", "Los4/f;", "Lcom/tencent/state/library/data/LibraryLikeResult;", "", "TAG", "Ljava/lang/String;", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryDataParserKt {
    private static final String TAG = "LibraryDataParser";

    public static final EnterRoomInfo parse(f parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        byte[] bArr = parse.f432166b;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.msgOffset");
        bs4.f fVar = parse.f432165a;
        Intrinsics.checkNotNullExpressionValue(fVar, "this.room");
        return new EnterRoomInfo(bArr, parse(fVar), parse.f432167c);
    }

    public static final DialogTagSetInfo toDialogTagSetInfo(c toDialogTagSetInfo) {
        h hVar;
        a aVar;
        Intrinsics.checkNotNullParameter(toDialogTagSetInfo, "$this$toDialogTagSetInfo");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        a[] aVarArr = toDialogTagSetInfo.f440010a;
        if (aVarArr != null) {
            for (a dialogTagInfo : aVarArr) {
                Intrinsics.checkNotNullExpressionValue(dialogTagInfo, "dialogTagInfo");
                arrayList.add(toLibraryTagInfo(dialogTagInfo));
            }
        }
        h[] hVarArr = toDialogTagSetInfo.f440011b;
        if (hVarArr != null) {
            for (h dialogTagInfo2 : hVarArr) {
                Intrinsics.checkNotNullExpressionValue(dialogTagInfo2, "dialogTagInfo");
                arrayList2.add(parse(dialogTagInfo2));
            }
        }
        d dVar = toDialogTagSetInfo.f440012c;
        CommonTagInfo commonTagInfo = null;
        TagCategoryInfo libraryTagInfo = (dVar == null || (aVar = dVar.f440013a) == null) ? null : toLibraryTagInfo(aVar);
        d dVar2 = toDialogTagSetInfo.f440012c;
        if (dVar2 != null && (hVar = dVar2.f440014b) != null) {
            commonTagInfo = parse(hVar);
        }
        return new DialogTagSetInfo(arrayList, arrayList2, libraryTagInfo, commonTagInfo);
    }

    public static final TagCategoryInfo toLibraryTagInfo(a toLibraryTagInfo) {
        Intrinsics.checkNotNullParameter(toLibraryTagInfo, "$this$toLibraryTagInfo");
        ArrayList arrayList = new ArrayList();
        h[] hVarArr = toLibraryTagInfo.f440009c;
        if (hVarArr != null) {
            for (h tagInfo : hVarArr) {
                Intrinsics.checkNotNullExpressionValue(tagInfo, "tagInfo");
                arrayList.add(parse(tagInfo));
            }
        }
        String str = toLibraryTagInfo.f440007a;
        Intrinsics.checkNotNullExpressionValue(str, "this.category");
        String str2 = toLibraryTagInfo.f440008b;
        Intrinsics.checkNotNullExpressionValue(str2, "this.categoryName");
        return new TagCategoryInfo(str, str2, arrayList);
    }

    public static final EnterRoomInfo parse(n parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        byte[] bArr = parse.f432178b;
        Intrinsics.checkNotNullExpressionValue(bArr, "this.msgOffset");
        bs4.f fVar = parse.f432177a;
        Intrinsics.checkNotNullExpressionValue(fVar, "this.room");
        return new EnterRoomInfo(bArr, parse(fVar), false);
    }

    public static final CommonRoomInfo parse(bs4.f parse) {
        List emptyList;
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        i[] iVarArr = parse.f29060d;
        Intrinsics.checkNotNullExpressionValue(iVarArr, "this.confs");
        RoomConfig parse2 = parse(iVarArr);
        if (parse2 == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "parse RoomInfo failed: decorator is null", null, 4, null);
            return null;
        }
        g[] gVarArr = parse.f29058b;
        Intrinsics.checkNotNullExpressionValue(gVarArr, "this.tableList");
        ArrayList<Table> arrayList = new ArrayList(gVarArr.length);
        for (g it : gVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(parse(it, parse2.getBackground().getSize()));
        }
        j[] jVarArr = parse.f29059c;
        Intrinsics.checkNotNullExpressionValue(jVarArr, "this.userList");
        ArrayList<User> arrayList2 = new ArrayList(jVarArr.length);
        for (j it5 : jVarArr) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList2.add(parse(it5));
        }
        for (Table table : arrayList) {
            Iterator it6 = arrayList.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it6.next();
                if (((Table) obj2).getId() == table.getLeftTableId()) {
                    break;
                }
            }
            table.setLeftTable((Table) obj2);
            Iterator it7 = arrayList.iterator();
            while (true) {
                if (!it7.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it7.next();
                if (((Table) obj3).getId() == table.getRightTableId()) {
                    break;
                }
            }
            table.setRightTable((Table) obj3);
            table.setBrand(parse2.getTableBrand());
            table.setExpect(parse2.getTableExpect());
            table.setExpectWithShare(parse2.getTableExpectWithShare());
            table.setExpectWithEdit(parse2.getTableExpectWithEdit());
        }
        for (User user : arrayList2) {
            Iterator it8 = arrayList.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it8.next();
                long id5 = ((Table) obj).getId();
                SitDownInfo sitDown = user.getSitDown();
                if (sitDown != null && id5 == sitDown.getTableId()) {
                    break;
                }
            }
            Table table2 = (Table) obj;
            if (table2 != null) {
                table2.setUser(user);
            }
            SitDownInfo sitDown2 = user.getSitDown();
            if (sitDown2 != null) {
                sitDown2.setTable(table2);
            }
        }
        long j3 = parse.f29057a;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new CommonRoomInfo(j3, emptyList, arrayList, arrayList2, parse2.getBackground(), parse2, null, 0, arrayList.size(), null, 704, null);
    }

    public static final Table parse(g parse, Size mapSize) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        bs4.c cVar = parse.f29066e;
        Intrinsics.checkNotNullExpressionValue(cVar, "this.tableImage");
        Image parse2 = parse(cVar);
        e eVar = parse.f29063b;
        Location mapLocation = CommonDataParserKt.toMapLocation(eVar.f29055a, eVar.f29056b, mapSize, parse2.getSize());
        long j3 = parse.f29062a;
        long j16 = parse.f29064c;
        long j17 = parse.f29065d;
        bs4.a aVar = parse.f29067f;
        Intrinsics.checkNotNullExpressionValue(aVar, "this.introBubbleOff");
        return new Table(j3, j16, j17, mapLocation, parse2, parse(aVar), null, null, null, TroopInfo.PAY_PRIVILEGE_ALL, null);
    }

    public static final User parse(j parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String valueOf = String.valueOf(parse.f29075a);
        k profile = parse.f29076b;
        Intrinsics.checkNotNullExpressionValue(profile, "profile");
        UserCommon parse2 = parse(profile, parse.f29075a);
        String dressKey = parse.f29077c;
        Intrinsics.checkNotNullExpressionValue(dressKey, "dressKey");
        UserStatus userStatus = CommonDataParserKt.toUserStatus(parse.f29078d);
        b bVar = parse.f29079e;
        return new User(valueOf, parse2, dressKey, userStatus, bVar != null ? parse(bVar) : null, null, null, null, null, null, null, 2016, null);
    }

    public static final UserCommon parse(k parse, long j3) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new UserCommon(j3, UserFormatKt.toNickName(parse.f29080a, j3), parse.f29081b, CommonDataParserKt.toGender(parse.f29082c));
    }

    public static final Image parse(bs4.c parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Application application = Square.INSTANCE.getApplication();
        String str = parse.f29049a;
        Intrinsics.checkNotNullExpressionValue(str, "this.url");
        return new Image(str, new Size(ViewExtensionsKt.calPx(application, parse.f29050b), ViewExtensionsKt.calPx(application, parse.f29051c)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r6.f29054c == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SitDownInfo parse(b parse) {
        boolean z16;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        long j3 = parse.f29039a;
        r rVar = parse.f29043e;
        Resource formatActionResource$default = rVar != null ? UserFormatKt.formatActionResource$default(rVar, false, parse.f29048j, 2, null) : null;
        bs4.d dVar = parse.f29044f;
        long j16 = dVar != null ? dVar.f29053b : 0L;
        if (dVar != null) {
            z16 = true;
        }
        z16 = false;
        long j17 = parse.f29040b;
        h hVar = parse.f29041c;
        CommonTagInfo parse2 = hVar != null ? parse(hVar) : null;
        h hVar2 = parse.f29042d;
        return new SitDownInfo(j3, formatActionResource$default, j16, z16, j17, parse2, hVar2 != null ? parse(hVar2) : null, parse.f29045g, null, 0L, 0, new Point(0, 0), 1792, null);
    }

    public static final CommonTagInfo parse(h parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String id5 = parse.f29069a;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        String text = parse.f29070b;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        return new CommonTagInfo(id5, text);
    }

    public static final Point parse(bs4.a parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Application application = Square.INSTANCE.getApplication();
        return new Point(ViewExtensionsKt.calPx(application, parse.f29037a), ViewExtensionsKt.calPx(application, parse.f29038b));
    }

    public static final RoomConfig parse(i parse) {
        List emptyList;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        try {
            byte[] bArr = parse.f29073b;
            Intrinsics.checkNotNullExpressionValue(bArr, "this.`val`");
            JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
            JSONObject optJSONObject = jSONObject.optJSONObject("table_attatched");
            Image parseImage = CommonDataParserKt.parseImage(jSONObject.optJSONObject("libraryinfo"));
            CommonConfig parseConfig = CommonDataParserKt.parseConfig(jSONObject);
            List<Decorator> parseDecorators = CommonDataParserKt.parseDecorators(jSONObject.optJSONArray("library_attatched"), parseImage.getSize());
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new RoomConfig(parseImage, parseConfig, parseDecorators, emptyList, CommonDataParserKt.parseTableDecorator(optJSONObject != null ? optJSONObject.optJSONObject("brand") : null), CommonDataParserKt.parseTableDecorator(optJSONObject != null ? optJSONObject.optJSONObject("expect") : null), CommonDataParserKt.parseTableDecorator(optJSONObject != null ? optJSONObject.optJSONObject("expect_share") : null), CommonDataParserKt.parseTableDecorator(optJSONObject != null ? optJSONObject.optJSONObject("expect_edit") : null), null, null, null, 1024, null);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "parse TerminalConf failed: " + th5.getMessage(), null, 4, null);
            return null;
        }
    }

    public static final LibraryLikeResult parse(os4.f parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new LibraryLikeResult(parse.f423985a);
    }

    public static final RoomConfig parse(i[] parse) {
        i iVar;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        int length = parse.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                iVar = null;
                break;
            }
            iVar = parse[i3];
            if (Intrinsics.areEqual(iVar.f29072a, "room_object")) {
                break;
            }
            i3++;
        }
        if (iVar == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "No TerminalConf has key 'room_object'", null, 4, null);
        }
        if (iVar != null) {
            return parse(iVar);
        }
        return null;
    }
}
