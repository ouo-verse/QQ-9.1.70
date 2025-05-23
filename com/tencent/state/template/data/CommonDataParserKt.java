package com.tencent.state.template.data;

import android.app.Application;
import android.graphics.Point;
import android.util.Size;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.state.VasExtensionsKt;
import com.tencent.state.data.Gender;
import com.tencent.state.data.Image;
import com.tencent.state.data.JumpInfo;
import com.tencent.state.data.Text;
import com.tencent.state.data.UserCommon;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import com.tencent.state.library.calendar.CalendarGuideConfig;
import com.tencent.state.map.Location;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.bubblesetting.SquareBubbleSkinKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SpecialStatus;
import com.tencent.state.template.service.VasSquareRoomService;
import fs4.a;
import fs4.b;
import fs4.c;
import fs4.d;
import fs4.e;
import fs4.k;
import fs4.l;
import fs4.m;
import fs4.n;
import fs4.o;
import fs4.q;
import fs4.r;
import fs4.s;
import fs4.t;
import fs4.v;
import hs4.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000\u00ec\u0001\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\f\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\b\u001a\f\u0010\f\u001a\u00020\u000b*\u0004\u0018\u00010\b\u001a\f\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\b\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\b\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\b\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015*\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u0003\u001a\f\u0010\u001b\u001a\u00020\u001a*\u0004\u0018\u00010\b\u001a\f\u0010\u001d\u001a\u00020\u001c*\u0004\u0018\u00010\b\u001a\f\u0010\u001f\u001a\u00020\u001e*\u0004\u0018\u00010\b\u001a\f\u0010 \u001a\u00020\u0006*\u0004\u0018\u00010\b\u001a\n\u0010\"\u001a\u00020!*\u00020\u0000\u001a\n\u0010$\u001a\u00020#*\u00020\u0000\u001a\n\u0010&\u001a\u00020%*\u00020\u0000\u001a6\u0010/\u001a\u0004\u0018\u00010.*\u00020'2\u001e\u0010-\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0012\u0004\u0018\u00010+0(j\u0002`,2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010/\u001a\u000201*\u000200\u001a\n\u0010/\u001a\u000203*\u000202\u001a\u0014\u0010/\u001a\u000203*\u0002022\b\u00104\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010/\u001a\u000206*\u000205\u001a\n\u0010/\u001a\u000208*\u000207\u001a\u0012\u0010/\u001a\u00020:*\u0002092\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010/\u001a\u00020>*\u00020;2\u0006\u0010=\u001a\u00020<\u001a\n\u0010/\u001a\u00020\t*\u00020?\u001a\n\u0010/\u001a\u00020A*\u00020@\u001a\n\u0010/\u001a\u00020C*\u00020B\u001a&\u0010F\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u0000\u001a\n\u0010/\u001a\u00020H*\u00020G*2\u0010I\"\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0012\u0004\u0018\u00010+0(2\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0006\u0012\u0004\u0018\u00010+0(\u00a8\u0006J"}, d2 = {"", HippyTKDListViewAdapter.X, "y", "Landroid/util/Size;", "mapSize", "size", "Lcom/tencent/state/map/Location;", "toMapLocation", "Lorg/json/JSONObject;", "Lcom/tencent/state/data/Image;", "parseImage", "Lcom/tencent/state/data/JumpInfo;", "parseJumpInfo", "Lcom/tencent/state/template/data/CommonHippyInfo;", "parseHippyInfo", "Lcom/tencent/state/data/Text;", "parseText", "Lcom/tencent/state/template/data/Decorator;", "parseTableDecorator", "parseRoomDecorator", "Lorg/json/JSONArray;", "", "Lcom/tencent/state/template/data/BuildingDecorator;", "parseBuildings", "parseBuildingDecorator", "parseDecorators", "Lcom/tencent/state/template/data/CommonConfig;", "parseConfig", "Lcom/tencent/state/library/calendar/CalendarEntryConfig;", "parseCalendarConfig", "Lcom/tencent/state/library/calendar/CalendarGuideConfig;", "parseCalendarGuideConfig", "parseThemePanelConfig", "Lcom/tencent/state/data/Gender;", "toGender", "Lcom/tencent/state/template/data/UserStatus;", "toUserStatus", "Lcom/tencent/state/template/data/TableType;", "toTableType", "Lfs4/n;", "Lkotlin/Function1;", "", "Lfs4/r;", "Lcom/tencent/state/template/data/RoomConfig;", "Lcom/tencent/state/template/data/RoomConfParser;", "roomConfParser", "Lcom/tencent/state/template/data/CommonRoomInfo;", "parse", "Lfs4/b;", "Lcom/tencent/state/template/data/ClickArea;", "Lfs4/s;", "Lcom/tencent/state/template/data/RoomThemeData;", "location", "Lfs4/m;", "Lcom/tencent/state/template/data/QuickSeatTable;", "Lfs4/t;", "Lcom/tencent/state/template/data/User;", "Lfs4/q;", "Lcom/tencent/state/template/data/Table;", "Lfs4/u;", "", "uin", "Lcom/tencent/state/data/UserCommon;", "Lfs4/e;", "Lfs4/c;", "Landroid/graphics/Point;", "Lfs4/d;", "Lcom/tencent/state/template/data/SitDownInfo;", "width", "height", "parseLocation", "Lfs4/l;", "Lcom/tencent/state/template/data/OperationAd;", "RoomConfParser", "state_square_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CommonDataParserKt {
    public static final CommonRoomInfo parse(n parse, Function1<? super r[], RoomConfig> roomConfParser, Size size) {
        List emptyList;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(roomConfParser, "roomConfParser");
        Object obj5 = parse.f400545d;
        Intrinsics.checkNotNullExpressionValue(obj5, "this.confs");
        RoomConfig invoke = roomConfParser.invoke(obj5);
        ArrayList arrayList = null;
        if (invoke == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "parse RoomInfo failed: decorator is null", null, 4, null);
            return null;
        }
        Size size2 = size != null ? size : invoke.getBackground().getSize();
        q[] qVarArr = parse.f400543b;
        Intrinsics.checkNotNullExpressionValue(qVarArr, "this.tableList");
        ArrayList<Table> arrayList2 = new ArrayList(qVarArr.length);
        for (q it : qVarArr) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(parse(it, size2));
        }
        t[] tVarArr = parse.f400544c;
        Intrinsics.checkNotNullExpressionValue(tVarArr, "this.userList");
        ArrayList<User> arrayList3 = new ArrayList(tVarArr.length);
        for (t it5 : tVarArr) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList3.add(parse(it5));
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        for (Table table : arrayList2) {
            Iterator it6 = arrayList2.iterator();
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
            Iterator it7 = arrayList2.iterator();
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
            table.setBrand(invoke.getTableBrand());
            table.setExpect(invoke.getTableExpect());
            table.setExpectWithShare(invoke.getTableExpectWithShare());
            table.setExpectWithEdit(invoke.getTableExpectWithEdit());
            Iterator it8 = emptyList.iterator();
            while (true) {
                if (!it8.hasNext()) {
                    obj4 = null;
                    break;
                }
                obj4 = it8.next();
                if (((Stall) obj4).getTables().contains(Long.valueOf(table.getId()))) {
                    break;
                }
            }
            table.setStall((Stall) obj4);
        }
        for (User user : arrayList3) {
            Iterator it9 = arrayList2.iterator();
            while (true) {
                if (!it9.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it9.next();
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
        s sVar = parse.f400546e;
        RoomThemeData parse2 = sVar != null ? parse(sVar, invoke.getThemeRefreshPanel()) : null;
        int i3 = parse.f400548g;
        if (i3 <= 0) {
            i3 = arrayList2.size();
        }
        int i16 = i3;
        l[] lVarArr = parse.f400549h;
        if (lVarArr != null) {
            if (!(!(lVarArr.length == 0))) {
                lVarArr = null;
            }
            if (lVarArr != null) {
                arrayList = new ArrayList(lVarArr.length);
                for (l it10 : lVarArr) {
                    Intrinsics.checkNotNullExpressionValue(it10, "it");
                    arrayList.add(parse(it10));
                }
            }
        }
        return new CommonRoomInfo(parse.f400542a, emptyList, arrayList2, arrayList3, invoke.getBackground(), invoke, parse2, parse.f400547f, i16, arrayList);
    }

    public static final BuildingDecorator parseBuildingDecorator(JSONObject jSONObject, Size mapSize) {
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        if (jSONObject == null) {
            return null;
        }
        Image parseImage = parseImage(jSONObject);
        JumpInfo parseJumpInfo = parseJumpInfo(jSONObject);
        Application application = Square.INSTANCE.getApplication();
        return new BuildingDecorator(parseJumpInfo.getJumpType(), parseJumpInfo.getJumpUrl(), parseImage, new Location(ViewExtensionsKt.calPx(application, jSONObject.optInt(HippyTKDListViewAdapter.X)), ViewExtensionsKt.calPx(application, jSONObject.optInt("y")), parseImage.getSize().getWidth(), parseImage.getSize().getHeight(), 0, 0, 48, null));
    }

    public static final List<BuildingDecorator> parseBuildings(JSONArray jSONArray, final Size mapSize) {
        List<BuildingDecorator> emptyList;
        List<BuildingDecorator> mapNotNull;
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        if (jSONArray != null && (mapNotNull = VasExtensionsKt.mapNotNull(jSONArray, new Function1<JSONObject, BuildingDecorator>() { // from class: com.tencent.state.template.data.CommonDataParserKt$parseBuildings$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BuildingDecorator invoke(JSONObject it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return CommonDataParserKt.parseBuildingDecorator(it, mapSize);
            }
        })) != null) {
            return mapNotNull;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public static final List<Decorator> parseDecorators(JSONArray jSONArray, final Size mapSize) {
        List<Decorator> emptyList;
        List<Decorator> mapNotNull;
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        if (jSONArray != null && (mapNotNull = VasExtensionsKt.mapNotNull(jSONArray, new Function1<JSONObject, Decorator>() { // from class: com.tencent.state.template.data.CommonDataParserKt$parseDecorators$$inlined$let$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Decorator invoke(JSONObject it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return CommonDataParserKt.parseRoomDecorator(it, mapSize);
            }
        })) != null) {
            return mapNotNull;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public static final JumpInfo parseJumpInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("jump_type", -1);
            String optString = jSONObject.optString("jump_url", "");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"jump_url\",\"\")");
            return new JumpInfo(optInt, optString);
        }
        return new JumpInfo(-1, "");
    }

    public static final Location parseLocation(int i3, int i16, int i17, int i18) {
        Application application = Square.INSTANCE.getApplication();
        return new Location(ViewExtensionsKt.calPx(application, i3), ViewExtensionsKt.calPx(application, i16), ViewExtensionsKt.calPx(application, i17), ViewExtensionsKt.calPx(application, i18), 0, 0, 48, null);
    }

    public static final Decorator parseRoomDecorator(JSONObject jSONObject, Size mapSize) {
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        if (jSONObject == null) {
            return null;
        }
        Image parseImage = parseImage(jSONObject);
        JumpInfo parseJumpInfo = parseJumpInfo(jSONObject);
        CommonHippyInfo parseHippyInfo = parseHippyInfo(jSONObject);
        String jumpUrl = parseJumpInfo.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            return new Decorator(parseImage, toMapLocation(jSONObject.optInt(HippyTKDListViewAdapter.X), jSONObject.optInt("y"), mapSize, parseImage.getSize()), null, 4, null);
        }
        return new EntryDecorator(parseJumpInfo.getJumpType(), parseJumpInfo.getJumpUrl(), parseHippyInfo, parseImage, toMapLocation(jSONObject.optInt(HippyTKDListViewAdapter.X), jSONObject.optInt("y"), mapSize, parseImage.getSize()), null, jSONObject.optString("bookshelf_animate"), jSONObject.optString("report_id"));
    }

    public static final Location toMapLocation(int i3, int i16, Size mapSize, Size size) {
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        Intrinsics.checkNotNullParameter(size, "size");
        Application application = Square.INSTANCE.getApplication();
        return new Location((ViewExtensionsKt.calPx(application, i3) + (mapSize.getWidth() / 2)) - (size.getWidth() / 2), ((-ViewExtensionsKt.calPx(application, i16)) + (mapSize.getHeight() / 2)) - (size.getHeight() / 2), size.getWidth(), size.getHeight(), 0, 0, 48, null);
    }

    public static final CommonHippyInfo parseHippyInfo(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(IHippyIPC.BUNDLE_HIPPY_INFO);
            CommonHippyInfo commonHippyInfo = optJSONObject != null ? new CommonHippyInfo(optJSONObject.optString("bundle_name", ""), optJSONObject.optString("domain_name", ""), optJSONObject.optBoolean("is_half_screen", false), optJSONObject.optBoolean("speed_up", true)) : null;
            if (commonHippyInfo != null) {
                return commonHippyInfo;
            }
        }
        return new CommonHippyInfo("", "", false, false);
    }

    public static final CalendarEntryConfig parseCalendarConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("is_show");
            String optString = jSONObject.optString("entry_url");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"entry_url\")");
            return new CalendarEntryConfig(optBoolean, optString, parseCalendarGuideConfig(jSONObject.optJSONObject("guide")));
        }
        return new CalendarEntryConfig(false, null, null, 7, null);
    }

    public static final CalendarGuideConfig parseCalendarGuideConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("is_show");
            String optString = jSONObject.optString("icon_url");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"icon_url\")");
            String optString2 = jSONObject.optString("title");
            Intrinsics.checkNotNullExpressionValue(optString2, "it.optString(\"title\")");
            String optString3 = jSONObject.optString("detail");
            Intrinsics.checkNotNullExpressionValue(optString3, "it.optString(\"detail\")");
            return new CalendarGuideConfig(optBoolean, optString, optString2, optString3);
        }
        return new CalendarGuideConfig(false, null, null, null, 15, null);
    }

    public static final CommonConfig parseConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("push_config");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("common_config");
            return new CommonConfig(optJSONObject != null ? optJSONObject.optLong("reconnect_time", 86400L) : 86400L, parseCalendarConfig(optJSONObject2 != null ? optJSONObject2.optJSONObject(QQPermissionConstants.Permission.CALENDAR_GROUP) : null));
        }
        return new CommonConfig(0L, null, 3, null);
    }

    public static final Image parseImage(JSONObject jSONObject) {
        if (jSONObject != null) {
            Application application = Square.INSTANCE.getApplication();
            String optString = jSONObject.optString("url");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"url\")");
            return new Image(optString, new Size(ViewExtensionsKt.calPx(application, jSONObject.optInt("w")), ViewExtensionsKt.calPx(application, jSONObject.optInt(h.F))));
        }
        return new Image("", new Size(0, 0));
    }

    public static final Text parseText(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Application application = Square.INSTANCE.getApplication();
        int calPx = ViewExtensionsKt.calPx(application, jSONObject.optInt("font"));
        String optString = jSONObject.optString("color");
        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"color\")");
        return new Text(calPx, optString, new Point(ViewExtensionsKt.calPx(application, jSONObject.optInt(HippyTKDListViewAdapter.X)), ViewExtensionsKt.calPx(application, jSONObject.optInt("y"))));
    }

    public static final Location parseThemePanelConfig(JSONObject jSONObject) {
        Application application = Square.INSTANCE.getApplication();
        if (jSONObject != null) {
            return new Location(ViewExtensionsKt.calPx(application, jSONObject.optInt(HippyTKDListViewAdapter.X)), ViewExtensionsKt.calPx(application, jSONObject.optInt("y")), ViewExtensionsKt.calPx(application, jSONObject.optInt("w")), ViewExtensionsKt.calPx(application, jSONObject.optInt(h.F)), 0, 0, 48, null);
        }
        return new Location(0, 0, 0, 0, 0, 0, 48, null);
    }

    public static final Decorator parseTableDecorator(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Application application = Square.INSTANCE.getApplication();
        Image parseImage = parseImage(jSONObject);
        JumpInfo parseJumpInfo = parseJumpInfo(jSONObject);
        CommonHippyInfo parseHippyInfo = parseHippyInfo(jSONObject);
        Location location = new Location(ViewExtensionsKt.calPx(application, jSONObject.optInt(HippyTKDListViewAdapter.X)), ViewExtensionsKt.calPx(application, jSONObject.optInt("y")), parseImage.getSize().getWidth(), parseImage.getSize().getHeight(), 0, 0, 48, null);
        Text parseText = parseText(jSONObject.optJSONObject("text"));
        String jumpUrl = parseJumpInfo.getJumpUrl();
        if (jumpUrl == null || jumpUrl.length() == 0) {
            return new Decorator(parseImage, location, parseText);
        }
        return new EntryDecorator(parseJumpInfo.getJumpType(), parseJumpInfo.getJumpUrl(), parseHippyInfo, parseImage, location, parseText, jSONObject.optString("bookshelf_animate"), jSONObject.optString("report_id"));
    }

    public static final TableType toTableType(int i3) {
        if (i3 == 0) {
            return TableType.TABLE_TYPE_NOT_FIXED;
        }
        if (i3 != 1) {
            return TableType.TABLE_TYPE_NOT_FIXED;
        }
        return TableType.TABLE_TYPE_FIXED;
    }

    public static final UserStatus toUserStatus(int i3) {
        if (i3 == 0) {
            return UserStatus.STAND_UP;
        }
        if (i3 != 1) {
            return UserStatus.STAND_UP;
        }
        return UserStatus.SIT_DOWN;
    }

    public static final Gender toGender(int i3) {
        if (i3 == 1) {
            return Gender.MALE;
        }
        if (i3 != 2) {
            return Gender.UNKNOWN;
        }
        return Gender.FEMALE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0017, code lost:
    
        r6 = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClickArea parse(b parse) {
        List emptyList;
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        CommonDataParserKt$parse$calPx$1 commonDataParserKt$parse$calPx$1 = new CommonDataParserKt$parse$calPx$1(Square.INSTANCE.getApplication());
        boolean z16 = parse.f400502b;
        k[] kVarArr = parse.f400501a;
        if (kVarArr == null || filterNotNull == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<k> list = filterNotNull;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            emptyList = new ArrayList(collectionSizeOrDefault);
            for (k kVar : list) {
                emptyList.add(new Point(commonDataParserKt$parse$calPx$1.invoke((CommonDataParserKt$parse$calPx$1) Integer.valueOf(kVar.f400532a)).intValue(), commonDataParserKt$parse$calPx$1.invoke((CommonDataParserKt$parse$calPx$1) Integer.valueOf(kVar.f400533b)).intValue()));
            }
        }
        return new ClickArea(z16, emptyList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0062, code lost:
    
        r13 = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final RoomThemeData parse(s parse) {
        List emptyList;
        List list;
        List emptyList2;
        List list2;
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String text = parse.f400572a;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        String textResource = parse.f400573b;
        Intrinsics.checkNotNullExpressionValue(textResource, "textResource");
        String signboard = parse.f400574c;
        Intrinsics.checkNotNullExpressionValue(signboard, "signboard");
        String background = parse.f400575d;
        Intrinsics.checkNotNullExpressionValue(background, "background");
        String option1Text = parse.f400576e;
        Intrinsics.checkNotNullExpressionValue(option1Text, "option1Text");
        String option2Text = parse.f400577f;
        Intrinsics.checkNotNullExpressionValue(option2Text, "option2Text");
        b[] bVarArr = parse.f400578g;
        if (bVarArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            ArrayList arrayList = new ArrayList(bVarArr.length);
            for (b it : bVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(parse(it));
            }
            list = arrayList;
        }
        m[] mVarArr = parse.f400579h;
        if (mVarArr == null || filterNotNull == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList2;
        } else {
            List list3 = filterNotNull;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = list3.iterator();
            while (it5.hasNext()) {
                arrayList2.add(parse((m) it5.next()));
            }
            list2 = arrayList2;
        }
        return new RoomThemeData(text, textResource, signboard, background, null, option1Text, option2Text, list, list2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0061, code lost:
    
        r12 = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final RoomThemeData parse(s parse, Location location) {
        List emptyList;
        List list;
        List emptyList2;
        List list2;
        List filterNotNull;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        String text = parse.f400572a;
        Intrinsics.checkNotNullExpressionValue(text, "text");
        String textResource = parse.f400573b;
        Intrinsics.checkNotNullExpressionValue(textResource, "textResource");
        String signboard = parse.f400574c;
        Intrinsics.checkNotNullExpressionValue(signboard, "signboard");
        String background = parse.f400575d;
        Intrinsics.checkNotNullExpressionValue(background, "background");
        String option1Text = parse.f400576e;
        Intrinsics.checkNotNullExpressionValue(option1Text, "option1Text");
        String option2Text = parse.f400577f;
        Intrinsics.checkNotNullExpressionValue(option2Text, "option2Text");
        b[] bVarArr = parse.f400578g;
        if (bVarArr == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            ArrayList arrayList = new ArrayList(bVarArr.length);
            for (b it : bVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(parse(it));
            }
            list = arrayList;
        }
        m[] mVarArr = parse.f400579h;
        if (mVarArr == null || filterNotNull == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList2;
        } else {
            List list3 = filterNotNull;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = list3.iterator();
            while (it5.hasNext()) {
                arrayList2.add(parse((m) it5.next()));
            }
            list2 = arrayList2;
        }
        return new RoomThemeData(text, textResource, signboard, background, location, option1Text, option2Text, list, list2);
    }

    public static final QuickSeatTable parse(m parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        CommonDataParserKt$parse$calPx$2 commonDataParserKt$parse$calPx$2 = new CommonDataParserKt$parse$calPx$2(Square.INSTANCE.getApplication());
        return new QuickSeatTable(parse.f400540a, new Point(commonDataParserKt$parse$calPx$2.invoke((CommonDataParserKt$parse$calPx$2) Integer.valueOf(parse.f400541b.f400532a)).intValue(), commonDataParserKt$parse$calPx$2.invoke((CommonDataParserKt$parse$calPx$2) Integer.valueOf(parse.f400541b.f400533b)).intValue()));
    }

    public static final User parse(t parse) {
        InterResourceInfo interResourceInfo;
        hs4.s sVar;
        hs4.s sVar2;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        try {
            fs4.h hVar = parse.f400586f;
            interResourceInfo = hVar == null ? null : InteractionMotionDataParserKt.parsePB(InterResourceInfo.INSTANCE, hVar);
        } catch (Exception e16) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), VasSquareRoomService.TAG, "parse interResourceInfo failed: " + e16, null, 4, null);
            interResourceInfo = null;
        }
        d dVar = parse.f400585e;
        if (((dVar == null || (sVar2 = dVar.f400510f) == null) ? null : sVar2.f406207g) == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "UserInfo", "\u7740\u88c5\u4fe1\u606f\u4e3a\u7a7a0", null, 4, null);
            d dVar2 = parse.f400585e;
            if (dVar2 != null && (sVar = dVar2.f400510f) != null) {
                u uVar = new u();
                uVar.f406219a = String.valueOf(parse.f400581a);
                Unit unit = Unit.INSTANCE;
                sVar.f406207g = uVar;
            }
        }
        String valueOf = String.valueOf(parse.f400581a);
        fs4.u profile = parse.f400582b;
        Intrinsics.checkNotNullExpressionValue(profile, "profile");
        UserCommon parse2 = parse(profile, parse.f400581a);
        String str = parse.f400583c;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        UserStatus userStatus = toUserStatus(parse.f400584d);
        d dVar3 = parse.f400585e;
        SitDownInfo parse3 = dVar3 != null ? parse(dVar3) : null;
        RelationType parse4 = UserFormatKt.parse(RelationType.INSTANCE, parse.f400587g);
        o oVar = parse.f400588h;
        SquareBubbleInfo parse5 = oVar != null ? SquareBubbleSkinKt.parse(oVar) : null;
        o oVar2 = parse.f400589i;
        SquareBubbleInfo parse6 = oVar2 != null ? SquareBubbleSkinKt.parse(oVar2) : null;
        o oVar3 = parse.f400590j;
        return new User(valueOf, parse2, str2, userStatus, parse3, null, interResourceInfo, parse4, parse5, parse6, oVar3 != null ? SquareBubbleSkinKt.parse(oVar3) : null);
    }

    public static final Table parse(q parse, Size mapSize) {
        Image image;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        e eVar = parse.f400566e;
        if (eVar == null || (image = parse(eVar)) == null) {
            image = new Image("", new Size(0, 0));
        }
        Image image2 = image;
        k kVar = parse.f400563b;
        Location mapLocation = toMapLocation(kVar.f400532a, kVar.f400533b, mapSize, image2.getSize());
        long j3 = parse.f400562a;
        long j16 = parse.f400564c;
        long j17 = parse.f400565d;
        c cVar = parse.f400567f;
        Intrinsics.checkNotNullExpressionValue(cVar, "this.introBubbleOff");
        return new Table(j3, j16, j17, mapLocation, image2, parse(cVar), null, null, toTableType(parse.f400568g), 192, null);
    }

    public static final UserCommon parse(fs4.u parse, long j3) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        return new UserCommon(j3, UserFormatKt.toNickName(parse.f400591a, j3), parse.f400592b, toGender(parse.f400593c));
    }

    public static final Image parse(e parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Application application = Square.INSTANCE.getApplication();
        String str = parse.f400514a;
        Intrinsics.checkNotNullExpressionValue(str, "this.url");
        return new Image(str, new Size(ViewExtensionsKt.calPx(application, parse.f400515b), ViewExtensionsKt.calPx(application, parse.f400516c)));
    }

    public static final Point parse(c parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Application application = Square.INSTANCE.getApplication();
        return new Point(ViewExtensionsKt.calPx(application, parse.f400503a), ViewExtensionsKt.calPx(application, parse.f400504b));
    }

    public static final SitDownInfo parse(d parse) {
        String str;
        OnlineStatus onlineStatus;
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        Application application = Square.INSTANCE.getApplication();
        long j3 = parse.f400505a;
        hs4.r rVar = parse.f400508d;
        Resource formatActionResource$default = rVar != null ? UserFormatKt.formatActionResource$default(rVar, false, parse.f400510f, 2, null) : null;
        long j16 = parse.f400506b;
        hs4.t tVar = parse.f400509e;
        if (tVar == null) {
            onlineStatus = new OnlineStatus(0, 0, 0, null, null, null, null, null, null, null, 1023, null);
        } else {
            int i3 = tVar.f406210b;
            int i16 = i3 == 0 ? tVar.f406209a : i3;
            int i17 = tVar.f406209a;
            String str2 = tVar.f406211c;
            Intrinsics.checkNotNullExpressionValue(str2, "statusInfo.title");
            String str3 = parse.f400509e.f406212d;
            Intrinsics.checkNotNullExpressionValue(str3, "statusInfo.icon");
            String str4 = parse.f400509e.f406213e;
            Intrinsics.checkNotNullExpressionValue(str4, "statusInfo.bigIcon");
            String str5 = parse.f400509e.f406214f;
            Intrinsics.checkNotNullExpressionValue(str5, "statusInfo.extData");
            SpecialStatus formatSpecialStatus = UserFormatKt.formatSpecialStatus(str5);
            byte[] bArr = parse.f400509e.f406215g;
            Intrinsics.checkNotNullExpressionValue(bArr, "statusInfo.customText");
            if (bArr.length == 0) {
                str = "";
            } else {
                byte[] bArr2 = parse.f400509e.f406215g;
                Intrinsics.checkNotNullExpressionValue(bArr2, "statusInfo.customText");
                str = new String(bArr2, Charsets.UTF_8);
            }
            hs4.t tVar2 = parse.f400509e;
            String str6 = tVar2.f406216h;
            String str7 = tVar2.f406217i;
            Intrinsics.checkNotNullExpressionValue(str7, "statusInfo.motionIcon");
            onlineStatus = new OnlineStatus(i16, i17, i3, str2, str3, str4, formatSpecialStatus, str, str6, str7);
        }
        return new SitDownInfo(j3, formatActionResource$default, 0L, false, j16, null, null, 0L, onlineStatus, parse.f400511g, parse.f400512h, parse.f400513i == null ? new Point() : new Point(ViewExtensionsKt.calPx(application, parse.f400513i.f400532a), ViewExtensionsKt.calPx(application, parse.f400513i.f400533b)));
    }

    public static final OperationAd parse(l parse) {
        Intrinsics.checkNotNullParameter(parse, "$this$parse");
        long j3 = parse.f400535a;
        long j16 = parse.f400536b;
        v vVar = parse.f400537c;
        Location parseLocation = parseLocation(vVar.f400596c, vVar.f400597d, vVar.f400594a, vVar.f400595b);
        String str = parse.f400537c.f400598e;
        Intrinsics.checkNotNullExpressionValue(str, "videoInfo.url");
        OperationAdVideo operationAdVideo = new OperationAdVideo(parseLocation, str);
        a aVar = parse.f400538d;
        Location parseLocation2 = parseLocation(aVar.f400497c, aVar.f400498d, aVar.f400495a, aVar.f400496b);
        String str2 = parse.f400538d.f400499e;
        Intrinsics.checkNotNullExpressionValue(str2, "backgroundInfo.url");
        return new OperationAd(j3, j16, operationAdVideo, new OperationAdBackground(parseLocation2, str2));
    }
}
