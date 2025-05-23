package com.tencent.mobileqq.nearbypro.map.debug;

import com.tencent.mobileqq.nearbypro.api.IMapNearbyDataService;
import com.tencent.mobileqq.nearbypro.api.map.SelfUserInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import qp4.e;
import xp4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\f\u001a\u00020\u0005R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/debug/a;", "", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLng;", "b", "", "index", "latLng", "Lgb2/c;", "d", "basePos", "c", "count", "a", "Ljava/util/List;", "TEST_CLUSTER_INFO", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f253436a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<LatLng> TEST_CLUSTER_INFO;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LatLng(24.124609818697042d, 102.37552583100312d));
        arrayList.add(new LatLng(31.69610567634954d, 108.05466693032652d));
        arrayList.add(new LatLng(24.124609818697042d, 102.37552583100312d));
        arrayList.add(new LatLng(31.69610567634954d, 108.05466693032652d));
        arrayList.add(new LatLng(37.20281636974147d, 122.17318174303296d));
        arrayList.add(new LatLng(34.492766738761894d, 119.42690683770495d));
        arrayList.add(new LatLng(32.00449440917555d, 108.2721840338017d));
        arrayList.add(new LatLng(31.367012092037296d, 95.08624216335626d));
        arrayList.add(new LatLng(18.602517068351727d, 101.89360133388008d));
        arrayList.add(new LatLng(35.56502286815476d, 106.07992610040503d));
        arrayList.add(new LatLng(31.16297311849144d, 122.57953869086792d));
        arrayList.add(new LatLng(22.81457633190899d, 121.5222615345109d));
        arrayList.add(new LatLng(33.78465035885398d, 108.17065243946976d));
        arrayList.add(new LatLng(41.476895472753895d, 102.19960345415419d));
        arrayList.add(new LatLng(44.33275104328146d, 125.57691116106066d));
        arrayList.add(new LatLng(43.83843426637185d, 101.30529469399062d));
        arrayList.add(new LatLng(26.15719762403712d, 107.0509479204862d));
        arrayList.add(new LatLng(26.65676817728981d, 114.06524816950461d));
        arrayList.add(new LatLng(26.611134963999405d, 118.85391554635255d));
        arrayList.add(new LatLng(16.631253806105747d, 107.87785753103283d));
        arrayList.add(new LatLng(34.278920103960054d, 118.9827526830076d));
        arrayList.add(new LatLng(25.519780050852273d, 103.47876305267721d));
        arrayList.add(new LatLng(28.710568711194455d, 103.0190880145381d));
        arrayList.add(new LatLng(25.457937906125935d, 114.09171971964095d));
        arrayList.add(new LatLng(33.329553240756525d, 108.62757704022923d));
        arrayList.add(new LatLng(36.236353631345786d, 104.5051549916717d));
        arrayList.add(new LatLng(25.019558709542395d, 111.42340919519938d));
        arrayList.add(new LatLng(31.342638672313303d, 127.22258894378297d));
        arrayList.add(new LatLng(50.744196580167305d, 106.56121383351935d));
        arrayList.add(new LatLng(35.600306897681705d, 109.6923543007193d));
        arrayList.add(new LatLng(26.709867780843783d, 108.1812808011608d));
        arrayList.add(new LatLng(31.593411848236588d, 107.88391834571537d));
        arrayList.add(new LatLng(33.833576417015486d, 120.35175689980974d));
        arrayList.add(new LatLng(32.79660021249803d, 106.2641661076775d));
        arrayList.add(new LatLng(41.691992076674005d, 113.4332095679686d));
        arrayList.add(new LatLng(28.389345142531326d, 110.10242398287004d));
        arrayList.add(new LatLng(36.34629404418219d, 107.91968781961965d));
        arrayList.add(new LatLng(42.51041335602571d, 103.33714100338352d));
        arrayList.add(new LatLng(38.92643888740613d, 109.82539947318553d));
        arrayList.add(new LatLng(19.714643813213687d, 98.51798706491881d));
        arrayList.add(new LatLng(34.42616984383968d, 114.82654481380034d));
        arrayList.add(new LatLng(23.574587286666798d, 117.58231682011785d));
        arrayList.add(new LatLng(35.01456014892562d, 115.70698963908181d));
        arrayList.add(new LatLng(36.30525135812374d, 90.33207155320555d));
        arrayList.add(new LatLng(30.706367830587578d, 107.99238426105997d));
        arrayList.add(new LatLng(38.30327941552511d, 112.5293711319807d));
        arrayList.add(new LatLng(26.68367336032376d, 114.76228133733268d));
        arrayList.add(new LatLng(26.357207829507505d, 97.69448034428665d));
        arrayList.add(new LatLng(39.71624154863827d, 121.30666336135695d));
        arrayList.add(new LatLng(34.36733629271701d, 109.93951149156054d));
        arrayList.add(new LatLng(45.22635405746451d, 92.9776519492121d));
        arrayList.add(new LatLng(29.010680096821517d, 103.4572549278969d));
        arrayList.add(new LatLng(25.45702732714365d, 117.7636385887999d));
        arrayList.add(new LatLng(29.56240393242597d, 89.9446226399098d));
        arrayList.add(new LatLng(35.29518685296253d, 91.44460845194793d));
        arrayList.add(new LatLng(42.47538173396563d, 90.2260752026564d));
        arrayList.add(new LatLng(18.334405512721702d, 118.30155518139689d));
        arrayList.add(new LatLng(29.90535827555546d, 105.66915004081665d));
        arrayList.add(new LatLng(24.726289479341933d, 105.61666810507202d));
        arrayList.add(new LatLng(18.035659915709545d, 112.55655806829742d));
        arrayList.add(new LatLng(29.90690531432295d, 113.6192979352857d));
        arrayList.add(new LatLng(42.18866288123114d, 121.52820364938158d));
        arrayList.add(new LatLng(29.852082183573724d, 124.29699926900511d));
        arrayList.add(new LatLng(35.49445180197213d, 115.10608806131077d));
        arrayList.add(new LatLng(29.73615913260437d, 103.84128600192246d));
        arrayList.add(new LatLng(37.13757172637573d, 124.99495261781937d));
        arrayList.add(new LatLng(20.771906996795117d, 99.57364872658799d));
        arrayList.add(new LatLng(20.22698391407481d, 120.74551369812418d));
        arrayList.add(new LatLng(40.773375636319514d, 121.12650229944457d));
        arrayList.add(new LatLng(41.46647850525063d, 110.43206144863152d));
        arrayList.add(new LatLng(40.79831912541881d, 97.90613132570853d));
        arrayList.add(new LatLng(31.384862501634657d, 101.99554916884168d));
        arrayList.add(new LatLng(21.570803711374246d, 107.18498491990972d));
        arrayList.add(new LatLng(28.652208905728777d, 106.22155471793074d));
        arrayList.add(new LatLng(28.15380589354491d, 109.37657779248613d));
        arrayList.add(new LatLng(33.24900064156791d, 108.72106001421483d));
        arrayList.add(new LatLng(24.049374861758277d, 103.03191496729977d));
        arrayList.add(new LatLng(27.088864620245197d, 117.21891667627128d));
        arrayList.add(new LatLng(31.12735723686758d, 99.4301679639331d));
        arrayList.add(new LatLng(24.961832613844965d, 125.32312690946054d));
        arrayList.add(new LatLng(33.676968093000575d, 96.38070264858936d));
        arrayList.add(new LatLng(40.21389616950355d, 114.87386980130414d));
        arrayList.add(new LatLng(43.843824447430165d, 114.15467154765632d));
        arrayList.add(new LatLng(34.7673055073683d, 113.7480346292435d));
        arrayList.add(new LatLng(31.528840500214862d, 108.0138436956464d));
        arrayList.add(new LatLng(24.594262775240225d, 119.8368350845709d));
        arrayList.add(new LatLng(38.62678244318107d, 103.79291946957635d));
        arrayList.add(new LatLng(36.08277327280872d, 109.3515753680865d));
        arrayList.add(new LatLng(43.07502840996675d, 115.42457455214537d));
        arrayList.add(new LatLng(37.06991087646434d, 96.56789758084149d));
        arrayList.add(new LatLng(24.806934939237316d, 98.70703264496632d));
        arrayList.add(new LatLng(39.25754475601377d, 92.95362965830363d));
        arrayList.add(new LatLng(20.060746287264752d, 105.82951142897993d));
        arrayList.add(new LatLng(32.58767125180039d, 114.94951050398578d));
        arrayList.add(new LatLng(18.189936316722633d, 105.72903732629993d));
        arrayList.add(new LatLng(34.07410377072112d, 94.67578569649412d));
        arrayList.add(new LatLng(47.43835346908009d, 103.50819485688963d));
        arrayList.add(new LatLng(42.83971822060836d, 108.06665772159472d));
        arrayList.add(new LatLng(15.427182413921026d, 106.77171185802021d));
        arrayList.add(new LatLng(25.709794406110916d, 107.43750034998774d));
        arrayList.add(new LatLng(34.778386089502064d, 117.41634946220421d));
        arrayList.add(new LatLng(35.01131502263728d, 110.85698247853395d));
        arrayList.add(new LatLng(24.124609818697042d, 102.37552583100312d));
        arrayList.add(new LatLng(31.69610567634954d, 108.05466693032652d));
        arrayList.add(new LatLng(37.20281636974147d, 122.17318174303296d));
        arrayList.add(new LatLng(34.492766738761894d, 119.42690683770495d));
        arrayList.add(new LatLng(32.00449440917555d, 108.2721840338017d));
        arrayList.add(new LatLng(31.367012092037296d, 95.08624216335626d));
        arrayList.add(new LatLng(18.602517068351727d, 101.89360133388008d));
        arrayList.add(new LatLng(35.56502286815476d, 106.07992610040503d));
        arrayList.add(new LatLng(31.16297311849144d, 122.57953869086792d));
        arrayList.add(new LatLng(22.81457633190899d, 121.5222615345109d));
        arrayList.add(new LatLng(33.78465035885398d, 108.17065243946976d));
        arrayList.add(new LatLng(41.476895472753895d, 102.19960345415419d));
        arrayList.add(new LatLng(44.33275104328146d, 125.57691116106066d));
        arrayList.add(new LatLng(43.83843426637185d, 101.30529469399062d));
        arrayList.add(new LatLng(26.15719762403712d, 107.0509479204862d));
        arrayList.add(new LatLng(26.65676817728981d, 114.06524816950461d));
        arrayList.add(new LatLng(26.611134963999405d, 118.85391554635255d));
        arrayList.add(new LatLng(16.631253806105747d, 107.87785753103283d));
        arrayList.add(new LatLng(34.278920103960054d, 118.9827526830076d));
        arrayList.add(new LatLng(25.519780050852273d, 103.47876305267721d));
        arrayList.add(new LatLng(28.710568711194455d, 103.0190880145381d));
        arrayList.add(new LatLng(25.457937906125935d, 114.09171971964095d));
        arrayList.add(new LatLng(33.329553240756525d, 108.62757704022923d));
        arrayList.add(new LatLng(36.236353631345786d, 104.5051549916717d));
        arrayList.add(new LatLng(25.019558709542395d, 111.42340919519938d));
        arrayList.add(new LatLng(31.342638672313303d, 127.22258894378297d));
        arrayList.add(new LatLng(50.744196580167305d, 106.56121383351935d));
        arrayList.add(new LatLng(35.600306897681705d, 109.6923543007193d));
        arrayList.add(new LatLng(26.709867780843783d, 108.1812808011608d));
        arrayList.add(new LatLng(31.593411848236588d, 107.88391834571537d));
        arrayList.add(new LatLng(33.833576417015486d, 120.35175689980974d));
        arrayList.add(new LatLng(32.79660021249803d, 106.2641661076775d));
        arrayList.add(new LatLng(41.691992076674005d, 113.4332095679686d));
        arrayList.add(new LatLng(28.389345142531326d, 110.10242398287004d));
        arrayList.add(new LatLng(36.34629404418219d, 107.91968781961965d));
        arrayList.add(new LatLng(42.51041335602571d, 103.33714100338352d));
        arrayList.add(new LatLng(38.92643888740613d, 109.82539947318553d));
        arrayList.add(new LatLng(19.714643813213687d, 98.51798706491881d));
        arrayList.add(new LatLng(34.42616984383968d, 114.82654481380034d));
        arrayList.add(new LatLng(23.574587286666798d, 117.58231682011785d));
        arrayList.add(new LatLng(35.01456014892562d, 115.70698963908181d));
        arrayList.add(new LatLng(36.30525135812374d, 90.33207155320555d));
        arrayList.add(new LatLng(30.706367830587578d, 107.99238426105997d));
        arrayList.add(new LatLng(38.30327941552511d, 112.5293711319807d));
        arrayList.add(new LatLng(26.68367336032376d, 114.76228133733268d));
        arrayList.add(new LatLng(26.357207829507505d, 97.69448034428665d));
        arrayList.add(new LatLng(39.71624154863827d, 121.30666336135695d));
        arrayList.add(new LatLng(34.36733629271701d, 109.93951149156054d));
        arrayList.add(new LatLng(45.22635405746451d, 92.9776519492121d));
        arrayList.add(new LatLng(29.010680096821517d, 103.4572549278969d));
        arrayList.add(new LatLng(25.45702732714365d, 117.7636385887999d));
        arrayList.add(new LatLng(29.56240393242597d, 89.9446226399098d));
        arrayList.add(new LatLng(35.29518685296253d, 91.44460845194793d));
        arrayList.add(new LatLng(42.47538173396563d, 90.2260752026564d));
        arrayList.add(new LatLng(18.334405512721702d, 118.30155518139689d));
        arrayList.add(new LatLng(29.90535827555546d, 105.66915004081665d));
        arrayList.add(new LatLng(24.726289479341933d, 105.61666810507202d));
        arrayList.add(new LatLng(18.035659915709545d, 112.55655806829742d));
        arrayList.add(new LatLng(29.90690531432295d, 113.6192979352857d));
        arrayList.add(new LatLng(42.18866288123114d, 121.52820364938158d));
        arrayList.add(new LatLng(29.852082183573724d, 124.29699926900511d));
        arrayList.add(new LatLng(35.49445180197213d, 115.10608806131077d));
        arrayList.add(new LatLng(29.73615913260437d, 103.84128600192246d));
        arrayList.add(new LatLng(37.13757172637573d, 124.99495261781937d));
        arrayList.add(new LatLng(20.771906996795117d, 99.57364872658799d));
        arrayList.add(new LatLng(20.22698391407481d, 120.74551369812418d));
        arrayList.add(new LatLng(40.773375636319514d, 121.12650229944457d));
        arrayList.add(new LatLng(41.46647850525063d, 110.43206144863152d));
        arrayList.add(new LatLng(40.79831912541881d, 97.90613132570853d));
        arrayList.add(new LatLng(31.384862501634657d, 101.99554916884168d));
        arrayList.add(new LatLng(21.570803711374246d, 107.18498491990972d));
        arrayList.add(new LatLng(28.652208905728777d, 106.22155471793074d));
        arrayList.add(new LatLng(28.15380589354491d, 109.37657779248613d));
        arrayList.add(new LatLng(33.24900064156791d, 108.72106001421483d));
        arrayList.add(new LatLng(24.049374861758277d, 103.03191496729977d));
        arrayList.add(new LatLng(27.088864620245197d, 117.21891667627128d));
        arrayList.add(new LatLng(31.12735723686758d, 99.4301679639331d));
        arrayList.add(new LatLng(24.961832613844965d, 125.32312690946054d));
        arrayList.add(new LatLng(33.676968093000575d, 96.38070264858936d));
        arrayList.add(new LatLng(40.21389616950355d, 114.87386980130414d));
        arrayList.add(new LatLng(43.843824447430165d, 114.15467154765632d));
        arrayList.add(new LatLng(34.7673055073683d, 113.7480346292435d));
        arrayList.add(new LatLng(31.528840500214862d, 108.0138436956464d));
        arrayList.add(new LatLng(24.594262775240225d, 119.8368350845709d));
        arrayList.add(new LatLng(38.62678244318107d, 103.79291946957635d));
        arrayList.add(new LatLng(36.08277327280872d, 109.3515753680865d));
        arrayList.add(new LatLng(43.07502840996675d, 115.42457455214537d));
        arrayList.add(new LatLng(37.06991087646434d, 96.56789758084149d));
        arrayList.add(new LatLng(24.806934939237316d, 98.70703264496632d));
        arrayList.add(new LatLng(39.25754475601377d, 92.95362965830363d));
        arrayList.add(new LatLng(20.060746287264752d, 105.82951142897993d));
        arrayList.add(new LatLng(32.58767125180039d, 114.94951050398578d));
        arrayList.add(new LatLng(18.189936316722633d, 105.72903732629993d));
        arrayList.add(new LatLng(34.07410377072112d, 94.67578569649412d));
        arrayList.add(new LatLng(47.43835346908009d, 103.50819485688963d));
        arrayList.add(new LatLng(42.83971822060836d, 108.06665772159472d));
        arrayList.add(new LatLng(15.427182413921026d, 106.77171185802021d));
        arrayList.add(new LatLng(25.709794406110916d, 107.43750034998774d));
        arrayList.add(new LatLng(34.778386089502064d, 117.41634946220421d));
        arrayList.add(new LatLng(35.01131502263728d, 110.85698247853395d));
        TEST_CLUSTER_INFO = arrayList;
    }

    a() {
    }

    private final List<LatLng> b() {
        SelfUserInfo selfUserInfo;
        LatLng a16;
        IMapNearbyDataService f16 = ab2.a.f25767a.f();
        if (f16 != null && (selfUserInfo = f16.getSelfUserInfo()) != null && (a16 = ab2.c.f25771a.a(selfUserInfo)) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 1; i3 < 100; i3++) {
                arrayList.add(f253436a.c(a16, i3));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private final LatLng c(LatLng basePos, int index) {
        return ab2.a.f25767a.y(new Pair<>(Integer.valueOf(index * 50), Integer.valueOf(index * 100)), basePos.latitude, basePos.longitude);
    }

    private final gb2.c d(int index, LatLng latLng) {
        int random;
        h hVar = new h();
        hVar.f448325a = index + 10000;
        random = RangesKt___RangesKt.random(new IntRange(0, 12), Random.INSTANCE);
        hVar.f448328d = "https://image.superqqshow.qq.com/qq/nearby/avatar//" + random + ".png";
        hVar.f448327c = "name_" + hVar.f448325a;
        e eVar = new e();
        eVar.f429215a = (float) latLng.latitude;
        eVar.f429216b = (float) latLng.longitude;
        hVar.f448326b = eVar;
        return new gb2.c(hVar, new LatLng(latLng.latitude, latLng.longitude));
    }

    @NotNull
    public final List<gb2.c> a(int count) {
        ArrayList arrayList = new ArrayList();
        List<LatLng> b16 = f253436a.b();
        int i3 = 0;
        while (i3 < count && i3 < b16.size()) {
            arrayList.add(f253436a.d(i3, b16.get(i3)));
            i3++;
        }
        int i16 = count - i3;
        if (i16 > 0) {
            for (int i17 = 0; i17 < i16; i17++) {
                List<LatLng> list = TEST_CLUSTER_INFO;
                if (i17 >= list.size()) {
                    break;
                }
                arrayList.add(f253436a.d(b16.size() + i17, list.get(i17)));
            }
        }
        return arrayList;
    }
}
